package com.joyven.wxbot.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/6
 * Time: 下午5:23
 * Description: {BaseRequest: { Uin: xxx, Sid: xxx, Skey: xxx, DeviceID: xxx },Code: 3,
 * FromUserName: 自己ID,ToUserName: 自己ID,ClientMsgId: 时间戳}
 *
 * @author zhoujunwen
 * @version 1.0
 */
public class WxStatusNofity {
    @JSONField(name = "BaseRequest")
    private WxInitBase baseRequest;

    @JSONField(name = "Code")
    private int code;

    @JSONField(name = "FromUserName")
    private String fromUserName;

    @JSONField(name = "ToUserName")
    private String toUserName;

    @JSONField(name = "ClientMsgId")
    private Long clientMsgId;

    public WxInitBase getBaseRequest() {
        return baseRequest;
    }

    public void setBaseRequest(WxInitBase baseRequest) {
        this.baseRequest = baseRequest;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public Long getClientMsgId() {
        return clientMsgId;
    }

    public void setClientMsgId(Long clientMsgId) {
        this.clientMsgId = clientMsgId;
    }
}
