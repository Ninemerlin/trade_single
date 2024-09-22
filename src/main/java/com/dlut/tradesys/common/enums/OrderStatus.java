package com.dlut.tradesys.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.dlut.tradesys.common.exceptions.BadRequestException;
import lombok.Getter;

@Getter
public enum OrderStatus {
    UNPAID(1, "未付款"),
    PAID(2, "已付款未发货"),
    SENT(3, "已发货未收货"),
    RECEIVED(4, "确认收货交易成功"),
    CANCELED(5, "交易取消订单关闭"),
    REFUNDING(6, "退款中"),
    REFUNDED(7, "已退款"),
    ;
    @EnumValue
    int value;
    String desc;

    OrderStatus(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static OrderStatus of(int value) {
        if (value == 1) {
            return UNPAID;
        }
        if (value == 2) {
            return PAID;
        }
        if (value == 3) {
            return SENT;
        }
        if (value == 4) {
            return RECEIVED;
        }
        if (value == 5) {
            return CANCELED;
        }
        if (value == 6) {
            return REFUNDING;
        }
        if (value == 7) {
            return REFUNDED;
        }
        throw new BadRequestException("订单状态错误");
    }
}
