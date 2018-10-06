package com.lwproject.wechatsell.exception;

import com.lwproject.wechatsell.enums.ExceptionEnum;
import lombok.Getter;

/**
 * @Author: LiuWang
 * @Created: 2018/8/26 14:24
 */
@Getter
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = code;
    }
    public OrderException(Integer code,String msg) {
        super(msg);
        this.code = code;
    }

}
