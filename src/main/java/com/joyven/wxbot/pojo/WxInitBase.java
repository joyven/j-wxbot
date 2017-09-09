package com.joyven.wxbot.pojo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/6
 * Time: 上午9:56
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
public class WxInitBase {
    @JSONField(name = "Uin")
    private Integer uin;
    @JSONField(name = "Sid")
    private String sid;
    @JSONField(name = "Skey")
    private String skey;
    @JSONField(name = "DeviceID")
    private String deviceID;

    public Integer getUin() {
        return uin;
    }

    public void setUin(Integer uin) {
        this.uin = uin;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String toJson() {
        return JSONObject.toJSONString(this);
    }
}
