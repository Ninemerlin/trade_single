package com.dlut.tradesys.service;

import com.dlut.tradesys.common.dto.ItemFormDTO;
import com.dlut.tradesys.common.pojo.Item;
import com.dlut.tradesys.common.pojo.result.Result;

public interface ItemService {
    Result itemSearch(Integer pageSize, Integer currentPage, String keyword, String category, String orderBy, Long shopId);

    Result addItem(ItemFormDTO form);

    Result modifyItem(Item item);

    Result deleteItem(Long itemId);

    boolean deductStockAndIncreaseSold(Long itemId, Integer amount);
}
