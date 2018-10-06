package com.lwproject.wechatsell.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单详情表
 *
 * @Author: LiuWang
 * @Created: 2018/8/25 20:58
 */
@Data
@Entity
@DynamicUpdate
public class OrderDetail {

    /**
     * 详情表订单 id
     */
    @Id
    private String detailId;

    /**
     * 订单 id
     */
    private String orderId;

    /**
     * 商品 id
     */
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
     * 商品数量
     */
    private Integer productQuantity;

    /**
     * 商品小图
     */
    private String productIcon;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
