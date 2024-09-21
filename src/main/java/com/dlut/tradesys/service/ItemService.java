package com.dlut.tradesys.service;

import com.dlut.tradesys.common.pojo.result.Result;

public interface ItemService {
    Result itemSearch(Integer pageSize, Integer currentPage, String keyword, String category, String orderBy);
}
