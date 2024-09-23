package com.dlut.tradesys.service;

import com.dlut.tradesys.common.pojo.result.Result;

public interface ShopService {
    Result getShop(Long userId);

    Result addShop(Long userId, String name);

    Result modifyShop(Long shopId, String name);

    Result deleteShop(Integer shopId);
}
