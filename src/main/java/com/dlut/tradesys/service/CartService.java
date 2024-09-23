package com.dlut.tradesys.service;

import com.dlut.tradesys.common.pojo.Cart;
import com.dlut.tradesys.common.pojo.result.Result;

public interface CartService {
    Result getCart(Long userId);

    Result addCart(Long userId, Cart cart);

    Result modifyCartAmount(Long cartId, Integer amount);

    Result deleteCart(Long cartId);
}
