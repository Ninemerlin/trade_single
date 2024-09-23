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
@TableName("cart")
public class Cart{
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Long itemId;
    private Integer amount;
    private Long specId;
    private Long shopId;
}
