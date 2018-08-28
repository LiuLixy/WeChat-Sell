package com.lwproject.wechatsell.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author yuisama
 * @date 2018/8/23 12:01
 */
@Entity
@Data
public class SellerInfo {
    @Id
    private String sellerId;
    private String username;
    private String password;
}
