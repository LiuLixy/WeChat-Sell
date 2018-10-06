package com.lwproject.wechatsell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: LiuWang
 * @Created: 2018/8/26 14:57
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
