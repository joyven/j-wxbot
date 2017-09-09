package com.joyven.wxbot.pojo.vo;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/9
 * Time: 上午9:22
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
public class CheckLoginMessage {
    private Integer code;
    private String msg;
    private Boolean res;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getRes() {
        return res;
    }

    public void setRes(Boolean res) {
        this.res = res;
    }
}
