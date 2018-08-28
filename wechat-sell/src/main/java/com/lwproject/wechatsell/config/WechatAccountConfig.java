package com.lwproject.wechatsell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yuisama
 * @date 2018/8/12
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {
    /**
     * 微信公众号appId
     */
    private String mpAppId;
    /**
     * 微信公众号appSecret
     */
    private String mpAppSecret;
}
