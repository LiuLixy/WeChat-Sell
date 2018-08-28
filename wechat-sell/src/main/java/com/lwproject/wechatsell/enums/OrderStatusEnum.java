package com.lwproject.wechatsell.enums;

import lombok.Getter;

/**
 * @author yuisama
 * @date 2018/8/17 15:48
 */
@Getter
public enum OrderStatusEnum implements IEnumCode {
    NEW(0, "新订单"),
    FINISHED(1, "订单完成"),
    CANCEL(2, "取消订单");
    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
