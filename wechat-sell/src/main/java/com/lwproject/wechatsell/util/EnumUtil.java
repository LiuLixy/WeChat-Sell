package com.lwproject.wechatsell.util;

import com.lwproject.wechatsell.enums.IEnumCode;

/**
 * @author yuisama
 * @date 2018/8/17 16:01
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
