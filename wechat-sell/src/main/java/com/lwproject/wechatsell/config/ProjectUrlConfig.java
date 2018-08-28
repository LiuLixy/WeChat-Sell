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
@ConfigurationProperties(prefix = "project-url")
public class ProjectUrlConfig {
    /**
     * 微信公众号授权回调路径
     */
    private String wechatMpAuthorize;
}
