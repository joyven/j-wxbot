package com.joyven.wxbot.message.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

import static com.joyven.wxbot.message.vo.MsgType.TEXT;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/8
 * Time: 下午5:32
 * Type: 1 文字消息,
 * Content: 要发送的消息,
 * FromUserName: 自己的ID,
 * ToUserName: 好友的ID,
 * LocalID: 与clientMsgId相同,
 * ClientMsgId: 时间戳左移4位随后补上4位随机数
 *
 * @author zhoujunwen
 * @version 1.0
 */
public class TextMsg extends OutputMsg implements Serializable {
    @JSONField(name = "Type")
    private Integer type = TEXT.getType();
    @JSONField(name = "Content")
    private String content;
    @JSONField(name = "FromUserName")
    private String fromUserName;
    @JSONField(name = "ToUserName")
    private String toUserName;
    @JSONField(name = "LocalID")
    private String localID;
    @JSONField(name = "ClientMsgId")
    private String clientMsgId;

    @Override
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getLocalID() {
        return localID;
    }

    public void setLocalID(String localID) {
        this.localID = localID;
    }

    public String getClientMsgId() {
        return clientMsgId;
    }

    public void setClientMsgId(String clientMsgId) {
        this.clientMsgId = clientMsgId;
    }
}
