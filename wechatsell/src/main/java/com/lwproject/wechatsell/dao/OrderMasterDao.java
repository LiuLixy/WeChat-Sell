package com.lwproject.wechatsell.dao;

import com.lwproject.wechatsell.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: LiuWang
 * @Created: 2018/8/26 10:30
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster, String> {
    /**
     * 通过买家微信 openid 分页查询订单
     *
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);

}
