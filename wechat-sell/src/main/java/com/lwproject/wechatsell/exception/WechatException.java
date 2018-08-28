package com.lwproject.wechatsell.exception;

import com.lwproject.wechatsell.enums.ExceptionEnum;

/**
 * @author yuisama
 * @date 2018/8/13
 */
public class WechatException extends RuntimeException {
    private Integer code;

    public WechatException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    public WechatException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
}
