package com.lwproject.wechatsell.service.impl;

import com.lwproject.wechatsell.entity.SellerInfo;
import com.lwproject.wechatsell.dao.SellerInfoDao;
import com.lwproject.wechatsell.service.ISellerInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuisama
 * @date 2018/8/23 12:24
 */
@Service
@Slf4j
public class SellerInfoServiceImpl implements ISellerInfoService {
    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Override
    public SellerInfo findByUserName(String username) {
        SellerInfo sellerInfo = sellerInfoDao.findByUsername(username);
        if (sellerInfo != null) {
            log.info("找到指定用户");
            return sellerInfo;
        } else {
            log.error("用户不存在..");
            return null;
        }
    }
}
