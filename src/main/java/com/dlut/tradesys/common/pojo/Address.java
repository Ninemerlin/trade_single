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
@TableName("address")
public class Address{
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long userId;
    private String province;
    private String city;
    private String town;
    private String mobile;
    private String street;
    private String receiver;
    private Integer isDefault;
}
