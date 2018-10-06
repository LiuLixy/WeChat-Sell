package com.lwproject.wechatsell.dto;

import lombok.Data;

/**
 * 购物车实体类
 *
 * @Author: LiuWang
 * @Created: 2018/8/25 20:17
 */
@Data
public class CartDTO {

    /**
     * 商品 id
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

    public CartDTO(){}
}
