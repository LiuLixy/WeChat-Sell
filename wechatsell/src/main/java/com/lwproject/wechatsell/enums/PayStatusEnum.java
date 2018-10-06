package com.lwproject.wechatsell.enums;

import lombok.Getter;

/**
 * @Author: LiuWang
 * @Created: 2018/8/26 14:20
 */
@Getter
public enum PayStatusEnum implements IEnumCode {

    /**
     * 支付状态
     */
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功");
    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
