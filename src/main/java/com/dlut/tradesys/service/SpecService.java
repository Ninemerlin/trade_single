package com.dlut.tradesys.service;

import com.dlut.tradesys.common.pojo.result.Result;

public interface SpecService {
    Result getSpec(Long itemId);

    Result addSpec(Long itemId, String name);

    Result deleteSpec(Long specId);
}
