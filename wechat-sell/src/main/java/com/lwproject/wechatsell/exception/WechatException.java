package com.lwproject.wechatsell.exception;

import com.lwproject.wechatsell.enums.ExceptionEnum;

/**
 * @Author: LiuWang
 * @Created: 2018/8/20 12:29
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
