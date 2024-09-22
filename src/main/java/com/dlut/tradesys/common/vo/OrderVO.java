package com.dlut.tradesys.common.vo;

import com.dlut.tradesys.common.enums.OrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderVO {
    private Long id;
    private Long buyerId;
    private Long shopId;
    private String shopName;
    private Integer totalPrice;
    private String paymentType;
    private String address;
    private OrderStatus status;
    private LocalDateTime createTime;
    private LocalDateTime payTime;
    private LocalDateTime consignTime;
    private LocalDateTime endTime;
    private List<OrderDetailVO> orderDetails;
}
