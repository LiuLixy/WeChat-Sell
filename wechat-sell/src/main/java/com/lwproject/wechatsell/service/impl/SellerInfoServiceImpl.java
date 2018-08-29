package com.lwproject.wechatsell.service.impl;

import com.lwproject.wechatsell.entity.SellerInfo;
import com.lwproject.wechatsell.repository.SellerInfoReposity;
import com.lwproject.wechatsell.service.ISellerInfoService;
import com.lwproject.wechatsell.repository.SellerInfoReposity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: LiuWang
 * @Created: 2018/8/26 14:34
 */
@Service
@Slf4j
public class SellerInfoServiceImpl implements ISellerInfoService {
    @Autowired
    private SellerInfoReposity sellerInfoReposity;

    @Override
    public SellerInfo findByUserName(String username) {
        SellerInfo sellerInfo = sellerInfoReposity.findByUsername(username);
        if (sellerInfo!=null) {
            log.info("找到指定用户");
            return sellerInfo;
        }
        else {
            log.error("用户不存在..");
            return null;
        }
    }
}
