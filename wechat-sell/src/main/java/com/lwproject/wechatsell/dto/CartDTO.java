package com.lwproject.wechatsell.dto;

import lombok.Data;

/**
 * 购物车
 *
 * @Author: LiuWang
 * @Created: 2018/8/18 14:02
 */
@Data
public class CartDTO {
    /**
     * 商品Id
     */
    private String productId;
    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public CartDTO() {
    }
}
