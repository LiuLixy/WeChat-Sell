package com.lwproject.wechatsell.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lwproject.wechatsell.enums.ProductStatusEnum;
import com.lwproject.wechatsell.util.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: LiuWang
 * @Created: 2018/8/25 16:03
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    /**
     * 商品 id
     */
    @Id
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品单价
     */
    private BigDecimal productPrice;

    /**
     * 商品库存
     */
    private Integer productStock;

    /**
     * 商品描述
     */
    private String productDescription;

    /**
     * 商品小图
     */
    private String productIcon;

    /**
     * 商品状态
     */
    private Integer productStatus;

    /**
     * 商品类目
     */
    private Integer categoryType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getEnumDataByCode(productStatus, ProductStatusEnum.class);
    }

}
