package com.dlut.tradesys.service;

import com.dlut.tradesys.common.pojo.result.Result;

public interface OrderDetailService {
    Result getOrderDetail(Long orderId);
}
