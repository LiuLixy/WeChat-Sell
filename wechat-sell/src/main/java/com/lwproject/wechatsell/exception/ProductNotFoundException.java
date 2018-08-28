package com.lwproject.wechatsell.exception;

import com.lwproject.wechatsell.enums.ExceptionEnum;
import lombok.Getter;

/**
 * @Author: LiuWang
 * @Created: 2018/8/19 19:24
 */
@Getter
public class ProductNotFoundException extends RuntimeException {
    private Integer code;

    public ProductNotFoundException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }
}
