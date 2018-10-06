package com.lwproject.wechatsell.exception;

/**
 * @Author: LiuWang
 * @Created: 2018/8/25 20:41
 */
public class WechatSellException extends RuntimeException {

    private Integer code;

    public WechatSellException(String message, Integer code) {
        super(message);
        this.code = code;
    }
}
