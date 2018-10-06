package com.lwproject.wechatsell.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 此类用于与数据库 product_category 相互映射
 *
 * @Author: LiuWang
 * @Created: 2018/8/20 18:26
 */
@Data
@Entity
@DynamicUpdate
public class ProductCategory {
    /**
     * 商品编号
     *
     * @Id 这个注解表示主键
     * @GeneratedValue 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    /**
     * 商品名称
     */
    private String categoryName;
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
}
