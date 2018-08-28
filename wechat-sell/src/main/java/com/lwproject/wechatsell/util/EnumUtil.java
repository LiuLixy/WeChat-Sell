package com.lwproject.wechatsell.util;

import com.lwproject.wechatsell.enums.IEnumCode;

/**
 * @Author: LiuWang
 * @Created: 2018/8/22 11:09
 */
public class EnumUtil {
    public static <T extends IEnumCode> T getEnumDataByCode(Integer code, Class<T> cls) {
        for (T each : cls.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
