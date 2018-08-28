package com.lwproject.wechatsell.dao;

import com.lwproject.wechatsell.entity.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yuisama
 * @date 2018/8/23 12:03
 */
public interface SellerInfoDao extends JpaRepository<SellerInfo, String> {
    SellerInfo findByUsername(String username);
}
