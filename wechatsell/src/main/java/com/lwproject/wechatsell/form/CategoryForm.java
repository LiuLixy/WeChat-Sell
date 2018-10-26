package com.lwproject.wechatsell.form;

import lombok.Data;

/**
 * 卖家端类目表单
 *
 * @Author: LiuWang
 * @Created: 2018/8/26 14:55
 */
@Data
public class CategoryForm {
    private String categoryName;
    private Integer categoryType;
    private Integer categoryId;
}
