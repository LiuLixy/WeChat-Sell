package com.lwproject.wechatsell.enums;

import lombok.Getter;

/**
 * @author yuisama
 * @date 2018/8/17 15:58
 */
@Getter
public enum PayStatusEnum implements IEnumCode {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功");
    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
