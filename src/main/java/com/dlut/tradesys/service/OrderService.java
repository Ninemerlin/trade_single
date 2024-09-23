package com.dlut.tradesys.service;

import com.dlut.tradesys.common.dto.OrderFormDTO;
import com.dlut.tradesys.common.pojo.result.Result;

public interface OrderService {
    Result getOrder(Long userId);

    Result createOrder(Long userId, OrderFormDTO form);

    Result deleteOrder(Long orderId);

    Result setOrderStatus(Long orderId, Integer status);

    Result getSellerOrder(Long userId);
}
