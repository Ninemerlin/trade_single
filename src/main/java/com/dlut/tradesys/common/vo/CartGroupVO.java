package com.dlut.tradesys.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CartGroupVO {
    private Long cartId;
    private Long itemId;
    private Long specId;
    private String name;
    private String image;
    private String spec;
    private Integer price;
    private Integer amount;
}
