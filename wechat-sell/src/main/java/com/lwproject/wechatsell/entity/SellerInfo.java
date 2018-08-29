package com.lwproject.wechatsell.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: LiuWang
 * @Created: 2018/8/26 10:26
 */
@Entity
@Data
public class SellerInfo {
    @Id
    private String sellerId;
    private String username;
    private String password;
}
