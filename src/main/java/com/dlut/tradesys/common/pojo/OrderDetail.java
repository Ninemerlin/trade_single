package com.dlut.tradesys.common.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("order_detail")
public class OrderDetail{
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long orderId;
    private Long itemId;
    private Integer amount;
    private String name;
    private String spec;
    private Integer price;
    private String image;
}
