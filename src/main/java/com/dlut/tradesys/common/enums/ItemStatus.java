package com.dlut.tradesys.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.dlut.tradesys.common.exceptions.BadRequestException;
import lombok.Getter;

@Getter
public enum ItemStatus {
    NORMAL(1, "正常"),
    MOVED(2, "下架"),
    DELETED(3, "删除"),
    ;
    @EnumValue
    int value;
    String desc;

    ItemStatus(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static ItemStatus of(int value) {
        if (value == 1) {
            return NORMAL;
        }
        if (value == 2) {
            return MOVED;
        }
        if (value == 3) {
            return DELETED;
        }
        throw new BadRequestException("物品状态错误");
    }
}
