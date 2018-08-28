package com.lwproject.wechatsell.enums;

import lombok.Getter;

/**
 * @Author: LiuWang
 * @Created: 2018/8/19 16:49
 */
@Getter
public enum ProductStatusEnum implements IEnumCode {
    /**
     * 商品状态枚举类
     */
    UP(0, "上架"),
    DOWN(1, "下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
