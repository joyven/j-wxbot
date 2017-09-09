package com.joyven.wxbot.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/6
 * Time: 下午5:33
 * Description: 群组成员信息
 *
 * @author zhoujunwen
 * @version 1.0
 */
public class WxMember {
    @JSONField(name = "Uin")
    private Integer uin;
    @JSONField(name = "UserName")
    private String userName;
    @JSONField(name = "AttrStatus")
    private Integer attrStatus;
    @JSONField(name = "PYInitial")
    private String pYInitial;
    @JSONField(name = "PYQuanPin")
    private String pYQuanPin;
    @JSONField(name = "RemarkPYInitial")
    private String remarkPYInitial;
    @JSONField(name = "RemarkPYQuanPin")
    private String remarkPYQuanPin;
    @JSONField(name = "MemberStatus")
    private Integer memberStatus;
    @JSONField(name = "DisplayName")
    private String displayName;
    @JSONField(name = "KeyWord")
    private String keyWord;

    public Integer getUin() {
        return uin;
    }

    public void setUin(Integer uin) {
        this.uin = uin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAttrStatus() {
        return attrStatus;
    }

    public void setAttrStatus(Integer attrStatus) {
        this.attrStatus = attrStatus;
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

    public String getRemarkPYQuanPin() {
        return remarkPYQuanPin;
    }

    public void setRemarkPYQuanPin(String remarkPYQuanPin) {
        this.remarkPYQuanPin = remarkPYQuanPin;
    }

    public Integer getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(Integer memberStatus) {
        this.memberStatus = memberStatus;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
