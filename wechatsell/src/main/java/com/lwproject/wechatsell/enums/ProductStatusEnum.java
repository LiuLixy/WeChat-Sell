package com.lwproject.wechatsell.enums;

import lombok.Getter;

/**
 * 商品状态枚举类
 *
 * @Author: LiuWang
 * @Created: 2018/8/25 16:12
 */
@Getter
public enum ProductStatusEnum implements IEnumCode {
    /**
     * 0 表示商品上架
     */
    UP(0, "上架"),
    /**
     * 1 表示商品下架
     */
    DOWN(1, "下架");

    private Integer code;
    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
