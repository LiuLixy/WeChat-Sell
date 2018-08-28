package com.lwproject.wechatsell.form;

import lombok.Data;

/**
 * 卖家端类目表单
 *
 * @author yuisama
 * @date 2018/8/23 10:35
 */
@Data
public class CategoryForm {
    private String categoryName;
    private Integer categoryType;
    private Integer categoryId;
}
