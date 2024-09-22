package com.dlut.tradesys.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderDetailVO { // 看需求, 暂时没用
    private Long orderDetailId;
    private Long orderId;
    private String name;
    private Integer amount;
    private String spec;
    private Integer price;
    private String image;
    private String category;
    private String brand;
}
