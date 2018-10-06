package com.lwproject.wechatsell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 用于三层之间商品类目与商品详情之间的实体类
 *
 * @Author: LiuWang
 * @Created: 2018/8/25 16:56
 */
@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOLists;

}
