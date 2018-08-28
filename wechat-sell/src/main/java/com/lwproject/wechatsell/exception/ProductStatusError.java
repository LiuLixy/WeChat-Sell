package com.lwproject.wechatsell.exception;

import com.lwproject.wechatsell.enums.ExceptionEnum;
import lombok.Getter;

/**
 * @author yuisama
 * @date 2018/8/21 11:08
 */
@Getter
public class ProductStatusError extends RuntimeException {
    private Integer code;

    public ProductStatusError(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }
}
