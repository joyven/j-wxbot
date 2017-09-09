package com.joyven.wxbot.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/6
 * Time: 下午5:36
 * Description: 微信用户自己的信息
 *
 * @author zhoujunwen
 * @version 1.0
 */
public class WxUser {
    @JSONField(name = "Uin")
    private Integer uin;
    @JSONField(name = "UserName")
    private String userNme;
    @JSONField(name = "NickName")
    private String nickName;
    @JSONField(name = "HeadImgUrl")
    private String headImgUrl;
    @JSONField(name = "RemarkName")
    private String remarkName;
    @JSONField(name = "PYInitial")
    private String pYInitial;
    @JSONField(name = "PYQuanPin")
    private String pYQuanPin;
    @JSONField(name = "RemarkPYInitial")
    private String remarkPYInitial;
    @JSONField(name = "HideInputBarFlag")
    private Integer hideInputBarFlag;
    @JSONField(name = "StarFriend")
    private Integer sarFriend;
    @JSONField(name = "Sex")
    private Integer sex;
    @JSONField(name = "Signature")
    private String signature;
    @JSONField(name = "AppAccountFlag")
    private Integer appAccountFlag;
    @JSONField(name = "VerifyFlag")
    private Integer verifyFlag;
    @JSONField(name = "ContactFlag")
    private Integer contactFlag;
    @JSONField(name = "WebWxPluginSwitch")
    private Integer webWxPluginSwitch;
    @JSONField(name = "HeadImgFlag")
    private Integer headImgFlag;
    @JSONField(name = "SnsFlag")
    private Integer snsFlag;

    public Integer getUin() {
        return uin;
    }

    public void setUin(Integer uin) {
        this.uin = uin;
    }

    public String getUserNme() {
        return userNme;
    }

    public void setUserNme(String userNme) {
        this.userNme = userNme;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    public String getpYInitial() {
        return pYInitial;
    }

    public void setpYInitial(String pYInitial) {
        this.pYInitial = pYInitial;
    }

    public String getpYQuanPin() {
        return pYQuanPin;
    }

    public void setpYQuanPin(String pYQuanPin) {
        this.pYQuanPin = pYQuanPin;
    }

    public String getRemarkPYInitial() {
        return remarkPYInitial;
    }

    public void setRemarkPYInitial(String remarkPYInitial) {
        this.remarkPYInitial = remarkPYInitial;
    }

    public Integer getHideInputBarFlag() {
        return hideInputBarFlag;
    }

    public void setHideInputBarFlag(Integer hideInputBarFlag) {
        this.hideInputBarFlag = hideInputBarFlag;
    }

    public Integer getSarFriend() {
        return sarFriend;
    }

    public void setSarFriend(Integer sarFriend) {
        this.sarFriend = sarFriend;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getAppAccountFlag() {
        return appAccountFlag;
    }

    public void setAppAccountFlag(Integer appAccountFlag) {
        this.appAccountFlag = appAccountFlag;
    }

    public Integer getVerifyFlag() {
        return verifyFlag;
    }

    public void setVerifyFlag(Integer verifyFlag) {
        this.verifyFlag = verifyFlag;
    }

    public Integer getContactFlag() {
        return contactFlag;
    }

    public void setContactFlag(Integer contactFlag) {
        this.contactFlag = contactFlag;
    }

    public Integer getWebWxPluginSwitch() {
        return webWxPluginSwitch;
    }

    public void setWebWxPluginSwitch(Integer webWxPluginSwitch) {
        this.webWxPluginSwitch = webWxPluginSwitch;
    }

    public Integer getHeadImgFlag() {
        return headImgFlag;
    }

    public void setHeadImgFlag(Integer headImgFlag) {
        this.headImgFlag = headImgFlag;
    }

    public Integer getSnsFlag() {
        return snsFlag;
    }

    public void setSnsFlag(Integer snsFlag) {
        this.snsFlag = snsFlag;
    }
}
