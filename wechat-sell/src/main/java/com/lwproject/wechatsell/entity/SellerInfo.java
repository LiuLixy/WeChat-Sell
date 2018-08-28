package com.lwproject.wechatsell.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: LiuWang
 * @Created: 2018/8/18 15:59
 */
@Entity
@Data
public class SellerInfo {
    @Id
    private String sellerId;
    private String username;
    private String password;
}
