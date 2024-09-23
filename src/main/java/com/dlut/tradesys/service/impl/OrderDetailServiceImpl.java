package com.dlut.tradesys.service.impl;

import com.dlut.tradesys.common.pojo.Address;
import com.dlut.tradesys.common.pojo.OrderDetail;
import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.mapper.OrderDetailMapper;
import com.dlut.tradesys.service.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailMapper orderDetailMapper;

    @Override
    public Result getOrderDetail(Long orderId) {
        List<OrderDetail> o = orderDetailMapper.getOrderDetail(orderId);
        if(o != null) {
            return Result.success().addMsg("订单详情查询成功.").addData("orderDetailList", o);
        }
        return Result.fail().addMsg("订单详情查询失败.");
    }
}
