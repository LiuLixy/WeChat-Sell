package com.lwproject.wechatsell.util;

import com.lwproject.wechatsell.vo.ResultVO;

/**
 * @Author: LiuWang
 * @Created: 2018/8/22 17:46
 */
public class ResultVOUtil {
    public static ResultVO success(Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO fail(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
