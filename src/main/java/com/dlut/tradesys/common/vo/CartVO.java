package com.dlut.tradesys.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CartVO {
    private Long shopId;
    private String shopName;
    private List<CartDetailVO> items;
}
