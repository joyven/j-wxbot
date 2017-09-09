package com.joyven.wxbot.pojo;

import com.alibaba.fastjson.JSONObject;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by zjw on 2017/9/5.
 */
@XmlRootElement(name = "error")
public class WxError {
    private int ret;
    private String message;
    private String skey;
    private String wxsid;
    private Integer wxuin;
    private String passTicket;
    private String isgrayscale;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    public String getWxsid() {
        return wxsid;
    }

    public void setWxsid(String wxsid) {
        this.wxsid = wxsid;
    }

    public Integer getWxuin() {
        return wxuin;
    }

    public void setWxuin(Integer wxuin) {
        this.wxuin = wxuin;
    }

    public String getPassTicket() {
        return passTicket;
    }

    @XmlElement(name = "pass_ticket")
    public void setPassTicket(String passTicket) {
        this.passTicket = passTicket;
    }

    public String getIsgrayscale() {
        return isgrayscale;
    }

    public void setIsgrayscale(String isgrayscale) {
        this.isgrayscale = isgrayscale;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
