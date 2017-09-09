package com.joyven.wxbot.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/6
 * Time: 下午5:31
 * Description: 微信联系人信息
 *
 * @author zhoujunwen
 * @version 1.0
 */
public class WxContact {
    @JSONField(name = "Uin")
    private Integer uin;
    @JSONField(name = "UserName")
    private String userName;
    @JSONField(name = "NickName")
    private String nickName;
    @JSONField(name = "HeadImgUrl")
    private String headImgUrl;
    @JSONField(name = "ContactFlag")
    private Integer contactFlag;
    @JSONField(name = "MemberCount")
    private Integer memberCount;
    @JSONField(name = "MemberList")
    private List<WxMember> memberList;
    @JSONField(name = "RemarkName")
    private String remarkName;
    @JSONField(name = "HideInputBarFlag")
    private Integer hideInputBarFlag;
    @JSONField(format = "Sex")
    private Integer sex;
    @JSONField(name = "Signature")
    private String signature;
    @JSONField(name = "VerifyFlag")
    private Integer verifyFlag;
    @JSONField(name = "OwnerUin")
    private Integer ownerUin;
    @JSONField(name = "PYInitial")
    private String pYInitial;
    @JSONField(name = "PYQuanPin")
    private String pYQuanPin;
    @JSONField(name = "RemarkPYInitial")
    private String remarkPYInitial;
    @JSONField(name = "RemarkPYQuanPin")
    private String remarkPYQuanPin;
    @JSONField(name = "StarFriend")
    private Integer starFriend;
    @JSONField(name = "AppAccountFlag")
    private Integer appAccountFlag;
    @JSONField(name = "Statues")
    private Integer statues;
    @JSONField(name = "AttrStatus")
    private Long attrStatus;
    @JSONField(name = "Province")
    private String province;
    @JSONField(name = "City")
    private String city;
    @JSONField(name = "Alias")
    private String alias;
    @JSONField(name = "SnsFlag")
    private Integer snsFlag;
    @JSONField(name = "UniFriend")
    private Integer uniFriend;
    @JSONField(name = "DisplayName")
    private String displayName;
    @JSONField(name = "ChatRoomId")
    private Long chatRoomId;
    @JSONField(name = "KeyWord")
    private String keyWord;
    @JSONField(name = "EncryChatRoomId")
    private String encryChatRoomId;
    @JSONField(name = "IsOwner")
    private Integer isOwner;

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

    public Integer getContactFlag() {
        return contactFlag;
    }

    public void setContactFlag(Integer contactFlag) {
        this.contactFlag = contactFlag;
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

    public List<WxMember> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<WxMember> memberList) {
        this.memberList = memberList;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    public Integer getHideInputBarFlag() {
        return hideInputBarFlag;
    }

    public void setHideInputBarFlag(Integer hideInputBarFlag) {
        this.hideInputBarFlag = hideInputBarFlag;
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

    public Integer getVerifyFlag() {
        return verifyFlag;
    }

    public void setVerifyFlag(Integer verifyFlag) {
        this.verifyFlag = verifyFlag;
    }

    public Integer getOwnerUin() {
        return ownerUin;
    }

    public void setOwnerUin(Integer ownerUin) {
        this.ownerUin = ownerUin;
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

    public Integer getStarFriend() {
        return starFriend;
    }

    public void setStarFriend(Integer starFriend) {
        this.starFriend = starFriend;
    }

    public Integer getAppAccountFlag() {
        return appAccountFlag;
    }

    public void setAppAccountFlag(Integer appAccountFlag) {
        this.appAccountFlag = appAccountFlag;
    }

    public Integer getStatues() {
        return statues;
    }

    public void setStatues(Integer statues) {
        this.statues = statues;
    }

    public Long getAttrStatus() {
        return attrStatus;
    }

    public void setAttrStatus(Long attrStatus) {
        this.attrStatus = attrStatus;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getSnsFlag() {
        return snsFlag;
    }

    public void setSnsFlag(Integer snsFlag) {
        this.snsFlag = snsFlag;
    }

    public Integer getUniFriend() {
        return uniFriend;
    }

    public void setUniFriend(Integer uniFriend) {
        this.uniFriend = uniFriend;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Long getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(Long chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getEncryChatRoomId() {
        return encryChatRoomId;
    }

    public void setEncryChatRoomId(String encryChatRoomId) {
        this.encryChatRoomId = encryChatRoomId;
    }

    public Integer getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(Integer isOwner) {
        this.isOwner = isOwner;
    }
}
