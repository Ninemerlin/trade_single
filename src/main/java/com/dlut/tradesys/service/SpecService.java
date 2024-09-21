package com.dlut.tradesys.service;

import com.dlut.tradesys.common.pojo.result.Result;

public interface SpecService {
    Result getSpec(Integer itemId);

    Result addSpec(Integer itemId, String name);

    Result deleteSpec(Integer specId);
}
