package com.lwproject.wechatsell.util;

import java.util.Random;

/**
 * @Author: LiuWang
 * @Created: 2018/8/26 14:05
 */
public class GenerateKeyUtil {

    /**
     * 生成 6 位随机字符串作为主键
     * @return
     */
    public static synchronized String getUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }

}
