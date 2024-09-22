package com.dlut.tradesys.common.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dlut.tradesys.common.enums.OrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("order")
public class Order{
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Integer totalPrice;
    private Integer paymentType;
    private Long sellerId;
    private Long buyerId;
    private Long shopId;
    private String address;
    private OrderStatus status;
    private LocalDateTime createTime;
    private LocalDateTime payTime;
    private LocalDateTime consignTime;
    private LocalDateTime endTime;
}
