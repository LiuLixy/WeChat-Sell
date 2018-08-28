package com.lwproject.wechatsell.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: LiuWang
 * @Created: 2018/8/18 15:09
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    /**
     * 订单Id
     */
    @Id
    private String orderId;
    /**
     * 买家姓名
     */
    private String buyerName;
    /**
     * 买家手机号
     */
    private String buyerPhone;
    /**
     * 买家地址
     */
    private String buyerAddress;
    private String buyerOpenid;
    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;
    /**
     * 订单状态，默认0为新下单
     */
    private Integer orderStatus = 0;
    /**
     * 支付状态，默认0为未支付
     */
    private Integer payStatus = 0;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}