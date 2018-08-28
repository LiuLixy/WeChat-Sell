package com.lwproject.wechatsell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 卖家端商品表单
 *
 * @Author: LiuWang
 * @Created: 2018/8/20 11:24
 */
@Data
public class ProductForm {
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    private Integer productStatus = 0;
    private Integer categoryType;
}
