package com.lwproject.wechatsell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品(包含类目)
 *
 * @Author: LiuWang
 * @Created: 2018/8/22 18:58
 */
@Data
public class ProductVO {
    /**
     * 类目名称
     */
    @JsonProperty("name")
    private String categoryName;
    /**
     * 类目类型
     */
    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOLists;
}
