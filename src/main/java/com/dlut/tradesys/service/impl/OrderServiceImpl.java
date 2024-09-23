package com.dlut.tradesys.service.impl;

import com.dlut.tradesys.common.dto.OrderFormDTO;
import com.dlut.tradesys.common.enums.OrderStatus;
import com.dlut.tradesys.common.pojo.*;
import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.mapper.*;
import com.dlut.tradesys.service.ItemService;
import com.dlut.tradesys.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;
    private final CartMapper cartMapper;
    private final AddressMapper addressMapper;
    private final ShopMapper shopMapper;
    private final ItemMapper itemMapper;
    private final SpecMapper specMapper;
    private final OrderDetailMapper orderDetailMapper;
    private final UserMapper userMapper;

    private final ItemService itemService;

    @Override
    public Result getOrder(Long userId) {
        List<Order> o = null;
        if(userMapper.getUserById(userId).getUserType() == 3){
            o = orderMapper.getAllOrders();
        } else {
            o = orderMapper.getOrder(userId);
        }
        if(o != null) {
            return Result.success().addMsg("订单查询成功.").addData("orderList",o);
        }
        return Result.fail().addMsg("订单查询失败.");
    }

    @Override
    public Result getSellerOrder(Long userId) {
        List<Order> o = null;
        if(userMapper.getUserById(userId).getUserType() == 3){
            o = orderMapper.getAllOrders();
        } else {
            o = orderMapper.getSellerOrder(userId);
        }
        if(o != null) {
            return Result.success().addMsg("卖家订单查询成功.").addData("orderList",o);
        }
        return Result.fail().addMsg("卖家订单查询失败.");
    }

    @Override
    public Result createOrder(Long userId, OrderFormDTO form) {
        Long shopId = form.getShopId();
        Long addressId = form.getAddressId();
        List<Long> cartIds = form.getCartIds();
        System.out.println("shopId " + shopId + " addressId " + addressId + " cartIds " + cartIds);

        Integer totalPrice = 0;
        for(Long cartId : cartIds) {
            Cart cart = cartMapper.getCartById(cartId);
            Integer price = itemMapper.getPriceById(cart.getItemId());
            totalPrice += cart.getAmount() * price;
        }
        Long sellerId = shopMapper.getOwnerIdByShopId(shopId);
        Address address = addressMapper.getAddressById(addressId);
        String addressStr = address.getProvince() + " " + address.getCity() + " " + address.getTown() + " " + address.getStreet()
                + " " + address.getReceiver() + " " + address.getMobile();
        Order order = new Order(null, totalPrice, 0, sellerId, userId, shopId, addressStr, OrderStatus.UNPAID, LocalDateTime.now(), null, null, null);

        if(orderMapper.createOrder(order)) {
            System.out.println(order.toString());
            for(Long cartId : cartIds) {
                // 创建orderDetail并移除cart
                Cart cart = cartMapper.getCartById(cartId);
                Item item = itemMapper.getItemById(cart.getItemId());
                String spec = specMapper.getSpecById(cart.getSpecId());
                OrderDetail orderDetail = new OrderDetail(null, order.getId(), item.getId(), cart.getAmount(), item.getName(), spec, item.getPrice(), item.getImage());
                if(orderDetailMapper.createOrderDetail(orderDetail) && itemService.deductStockAndIncreaseSold(cart.getItemId(), cart.getAmount())){
                    System.out.println(orderDetail.toString());
                } else {
                    return Result.fail().addMsg("订单详情创建失败.");
                }
                // cartMapper.deleteCart(cartId); // 测试先注了
            }
            return Result.success().addMsg("订单创建成功.");
        }
        return Result.fail().addMsg("订单创建失败.");
    }

    @Override
    public Result createOrderAtOnce(Long userId, Long addressId, Cart cart) {
        Item item = itemMapper.getItemById(cart.getItemId());
        Long shopId = item.getShopId();
        Integer amount = cart.getAmount();
        Address address = addressMapper.getAddressById(addressId);
        String addressStr = address.getProvince() + " " + address.getCity() + " " + address.getTown() + " " + address.getStreet()
                + " " + address.getReceiver() + " " + address.getMobile();
        Order order = new Order(null, item.getPrice() * amount, 0, shopMapper.getOwnerIdByShopId(shopId), userId, shopId, addressStr, OrderStatus.UNPAID, LocalDateTime.now(), null, null, null);

        if(orderMapper.createOrder(order)) {
            System.out.println(order.toString());
            String spec = specMapper.getSpecById(cart.getSpecId());
            OrderDetail orderDetail = new OrderDetail(null, order.getId(), item.getId(), amount, item.getName(), spec, item.getPrice(), item.getImage());
            if(orderDetailMapper.createOrderDetail(orderDetail) && itemService.deductStockAndIncreaseSold(item.getId(), amount)){
                System.out.println(orderDetail.toString());
            } else {
                return Result.fail().addMsg("订单详情创建失败(立即支付).");
            }
            return Result.success().addMsg("订单创建成功(立即支付).");
        }
        return Result.fail().addMsg("订单创建失败(立即支付).");
    }

    @Override
    public Result deleteOrder(Long orderId) {
        if(orderDetailMapper.deleteOrderDetailByOrderId(orderId) && orderMapper.deleteOrder(orderId)) {
            return Result.success().addMsg("订单删除成功.");
        }
        return Result.fail().addMsg("订单删除失败.");
    }

    @Override
    public Result setOrderStatus(Long orderId, Integer status) {
        Integer orderStatus = orderMapper.getOrderStatus(orderId);
        if(orderStatus == 4 || orderStatus == 5 || orderStatus == 7) {
            Result.fail().addMsg("订单流程已结束.");
        }
        switch(status) {
            case 2:
                orderMapper.setPayTime(orderId, LocalDateTime.now());
                break;
            case 3:
                orderMapper.setConsignTime(orderId, LocalDateTime.now());
                break;
            case 5:
            case 7:
                List<OrderDetail> orderDetails = orderDetailMapper.getOrderDetail(orderId);
                for(OrderDetail orderDetail : orderDetails) {
                    if(itemService.increaseStockAndDeductSold(orderDetail.getItemId(), orderDetail.getAmount())) {
                        System.out.println(orderDetail.toString() + " Recovered.");
                    } else {
                        return Result.fail().addMsg("订单状态修改失败, 商品数据恢复错误.");
                    }
                }
            case 4:
                orderMapper.setEndTime(orderId, LocalDateTime.now());
                break;
        }
        if(orderMapper.setOrderStatus(orderId, status)) {
            return Result.success().addMsg("订单状态修改成功.");
        }
        return Result.fail().addMsg("订单状态修改失败.");
    }
}
