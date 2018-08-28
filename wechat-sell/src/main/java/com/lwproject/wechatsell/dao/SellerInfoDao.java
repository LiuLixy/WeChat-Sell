package com.lwproject.wechatsell.dao;

import com.lwproject.wechatsell.entity.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: LiuWang
 * @Created: 2018/8/18 11:52
 */
public interface SellerInfoDao extends JpaRepository<SellerInfo, String> {
    SellerInfo findByUsername(String username);
}
