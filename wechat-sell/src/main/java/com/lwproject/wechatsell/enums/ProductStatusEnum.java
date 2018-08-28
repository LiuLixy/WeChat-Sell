package com.lwproject.wechatsell.enums;

import lombok.Getter;

/**
 * @author yuisama
 * @date 2018/8/20 23:27
 */
@Getter
public enum ProductStatusEnum implements IEnumCode {
    UP(0, "上架"),
    DOWN(1, "下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
