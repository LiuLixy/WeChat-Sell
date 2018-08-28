package com.lwproject.wechatsell.exception;

import com.lwproject.wechatsell.enums.ExceptionEnum;
import lombok.Getter;

/**
 * @author yuisama
 * @date 2018/8/9
 */
@Getter
public class ProductStockErrorException extends RuntimeException {
    private Integer code;

    public ProductStockErrorException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }
}
