package com.dlut.tradesys.common.dto;

import com.dlut.tradesys.common.pojo.Spec;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ItemFormDTO {
    private String name;
    private Integer price;
    private Integer stock;
    private String image;
    private String category;
    private String brand;
    private Long shopId;
    private List<Spec> specList;
}
