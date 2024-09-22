package com.dlut.tradesys.common.dto;

import com.dlut.tradesys.common.vo.CartDetailVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderFormDTO {
    private List<CartDetailVO> items;
}
