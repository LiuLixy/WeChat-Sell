package com.lwproject.wechatsell.util;

import java.util.Random;

/**
 * 生成随机数工具类
 *
 * @Author: LiuWang
 * @Created: 2018/8/22 08:46
 */
public class GenerateKeyUtil {
    /**
     * 生成6位随机字符串作为主键
     *
     * @return
     */
    public static synchronized String getUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
