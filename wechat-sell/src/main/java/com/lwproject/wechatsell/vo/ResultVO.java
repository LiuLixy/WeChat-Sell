package com.lwproject.wechatsell.vo;

import lombok.Data;

/**
 * 请求返回的最外层对象
 *
 * @author yuisama
 * @date 2018/8/6 16:35
 */
@Data
public class ResultVO<T> {
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回的具体内容
     */
    private T data;
}
