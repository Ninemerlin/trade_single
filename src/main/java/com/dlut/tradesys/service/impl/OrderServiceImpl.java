package com.dlut.tradesys.service.impl;

import com.dlut.tradesys.common.dto.OrderFormDTO;
import com.dlut.tradesys.common.enums.OrderStatus;
import com.dlut.tradesys.common.pojo.*;
import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.mapper.*;
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

    @Override
    public Result getOrder(Long userId) {
        List<Order> o = orderMapper.getOrder(userId);
        if(o != null) {
            return Result.success().addMsg("订单查询成功.").addData("orderList",o);
        }
        return Result.fail().addMsg("订单查询失败.");
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
                if(orderDetailMapper.createOrderDetail(orderDetail)){
                    System.out.println(orderDetail.toString());
                }
                // cartMapper.deleteCart(cartId); // 测试先注了
            }
            return Result.success().addMsg("订单创建成功.");
        }
        return Result.fail().addMsg("订单创建失败.");
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
        switch(status){
            case 2:
                orderMapper.setPayTime(orderId, LocalDateTime.now());
                break;
            case 3:
                orderMapper.setConsignTime(orderId, LocalDateTime.now());
                break;
            case 4:
            case 5:
            case 7:
                orderMapper.setEndTime(orderId, LocalDateTime.now());
                break;
        }
        if(orderMapper.setOrderStatus(orderId, status)) {
            return Result.success().addMsg("订单状态修改成功.");
        }
        return Result.fail().addMsg("订单状态修改失败.");
    }
}
