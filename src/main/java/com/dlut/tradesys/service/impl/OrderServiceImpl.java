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

        Order order = new Order();
        order.setCreateTime(LocalDateTime.now());
        order.setStatus(OrderStatus.UNPAID);
        Address address = addressMapper.getAddressById(addressId);
        String addressStr = address.getProvince() + " " + address.getCity() + " " + address.getTown() + " " + address.getStreet()
                + " " + address.getReceiver() + " " + address.getMobile();
        order.setAddress(addressStr);
        order.setShopId(shopId);
        order.setBuyerId(userId);
        order.setSellerId(shopMapper.getOwnerIdByShopId(shopId));
        order.setPaymentType(0);
        Integer totalPrice = 0;
        for(Long cartId : cartIds) {
            Cart cart = cartMapper.getCartById(cartId);
            Integer price = itemMapper.getPriceById(cart.getItemId());
            totalPrice += cart.getAmount() * price;
        }
        order.setTotalPrice(totalPrice);

        if(orderMapper.createOrder(order)) {
            System.out.println(order.toString());
            for(Long cartId : cartIds) {
                // 创建orderDetail并移除cart
                Cart cart = cartMapper.getCartById(cartId);
                Item item = itemMapper.getItemById(cart.getItemId());
                String spec = specMapper.getSpecById(cart.getSpecId());

                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderId(order.getId());
                orderDetail.setItemId(item.getId());
                orderDetail.setAmount(cart.getAmount());
                orderDetail.setName(item.getName());
                orderDetail.setSpec(spec);
                orderDetail.setPrice(item.getPrice());
                orderDetail.setImage(item.getImage());
                if(orderDetailMapper.createOrderDetail(orderDetail)){
                    System.out.println(orderDetail.toString());
                }
                // cartMapper.deleteCart(cartId);
            }
            return Result.success().addMsg("订单创建成功.");
        }
        return Result.fail().addMsg("订单创建失败.");
    }
}
