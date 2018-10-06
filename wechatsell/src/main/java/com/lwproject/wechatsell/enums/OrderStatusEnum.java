package com.lwproject.wechatsell.enums;

import lombok.Getter;

/**
 * @Author: LiuWang
 * @Created: 2018/8/25 21:03
 */
@Getter
public enum OrderStatusEnum implements IEnumCode {
    /**
     * 订单状态
     */
    NEW(0, "新订单"),
    FINISHED(1, "已完成"),
    CANCEL(2, "已取消");

    private Integer code;

    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
