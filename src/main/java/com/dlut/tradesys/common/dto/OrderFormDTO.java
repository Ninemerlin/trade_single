package com.dlut.tradesys.common.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderFormDTO {
    private Long shopId;
    private Long addressId;
    private List<Long> cartIds;
}
