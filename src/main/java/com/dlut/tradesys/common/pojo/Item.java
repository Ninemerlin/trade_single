package com.dlut.tradesys.common.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dlut.tradesys.common.enums.ItemStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("item")
public class Item{
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer price;
    private Integer stock;
    private String image;
    private String category;
    private String brand;
//    private String spec;
    private Integer sold;
    private ItemStatus status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Long shopId;
}
