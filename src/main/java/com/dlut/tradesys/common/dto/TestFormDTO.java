package com.dlut.tradesys.common.dto;

import com.dlut.tradesys.common.pojo.Shop;
import lombok.Data;

import java.util.List;

@Data
public class TestFormDTO {
    private String name;
    private String password;
    private List<Shop> list;
}
