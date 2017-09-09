package com.joyven.wxbot.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/6
 * Time: 下午6:07
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
public class WxBaseResponse {
    @JSONField(name = "Ret")
    private Integer ret;
    @JSONField(name = "ErrMsg")
    private String errMsg;

    public Integer getRet() {
        return ret;
    }

    public void setRet(Integer ret) {
        this.ret = ret;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
