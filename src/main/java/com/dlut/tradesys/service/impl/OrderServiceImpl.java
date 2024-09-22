package com.dlut.tradesys.service.impl;

import com.dlut.tradesys.common.pojo.Order;
import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.mapper.OrderMapper;
import com.dlut.tradesys.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;

    @Override
    public Result getOrder(Long userId) {
        List<Order> o = orderMapper.getOrder(userId);
        if(o != null) {
            return Result.success().addMsg("订单查询成功.").addData("orderList",o);
        }
        return Result.fail().addMsg("订单查询失败.");
    }
}
