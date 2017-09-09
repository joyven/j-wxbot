package com.joyven.wxbot.message.vo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/10
 * Time: 上午7:04
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
public class WxInitOutputMsg extends OutputMsg {
    @JSONField(name = "Type")
    private Integer type = MsgType.INIT.getType();
    @JSONField(name = "FromUserName")
    private String fromUserName;
    @JSONField(name = "ToUserNam")
    private String toUserName;
    @JSONField(name = "StatusNotifyUserName")
    private String statusNotifyUserName; // 最近联系的联系人ID
    @JSONField(name = "Content")
    private String content;
    @Override
    public Integer getType() {
        return null;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getStatusNotifyUserName() {
        return statusNotifyUserName;
    }

    public void setStatusNotifyUserName(String statusNotifyUserName) {
        this.statusNotifyUserName = statusNotifyUserName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
