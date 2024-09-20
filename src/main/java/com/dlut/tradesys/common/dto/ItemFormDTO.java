package com.dlut.tradesys.common.dto;

import com.dlut.tradesys.common.enums.ItemStatus;
import com.dlut.tradesys.common.pojo.Spec;

import java.time.LocalDateTime;
import java.util.List;

public class ItemFormDTO {
    private Long id;
    private String name;
    private Integer price;
    private Integer stock;
    private String image;
    private String category;
    private String brand;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Long shopId;
    private List<Spec> specList;
}
