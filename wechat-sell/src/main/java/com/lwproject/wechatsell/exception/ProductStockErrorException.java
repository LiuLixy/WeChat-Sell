package com.lwproject.wechatsell.exception;

import com.lwproject.wechatsell.enums.ExceptionEnum;
import lombok.Getter;

/**
 * @Author: LiuWang
 * @Created: 2018/8/19 19:48
 */
@Getter
public class ProductStockErrorException extends RuntimeException {
    private Integer code;

    public ProductStockErrorException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }
}
