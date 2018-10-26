package com.lwproject.wechatsell.enums;

import lombok.Getter;

/**
 * @Author: LiuWang
 * @Created: 2018/8/25 21:03
 */
@Getter
public enum OrderStatusEnum implements IEnumCode {
    /**
     * 订单状态枚举类
     */
    NEW(0,"新订单"),
    FINISHED(1,"订单完成"),
    CANCEL(2,"取消订单");
    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
