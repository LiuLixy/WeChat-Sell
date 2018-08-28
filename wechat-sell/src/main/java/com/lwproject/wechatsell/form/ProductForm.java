package com.lwproject.wechatsell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 卖家端商品表单
 *
 * @author yuisama
 * @date 2018/8/22 17:06
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
