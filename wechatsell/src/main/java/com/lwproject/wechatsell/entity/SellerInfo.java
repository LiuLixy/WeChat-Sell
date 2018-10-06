package com.lwproject.wechatsell.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: LiuWang
 * @Created: 2018/8/26 10:26
 */
@Data
@Entity
@DynamicUpdate
public class SellerInfo {
    /**
     * 卖家 id
     */
    @Id
    private String sellerId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
