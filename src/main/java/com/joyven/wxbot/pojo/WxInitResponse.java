package com.joyven.wxbot.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/6
 * Time: 下午6:06
 * Description: 微信初始化拉取数据
 *
 * @author zhoujunwen
 * @version 1.0
 */
public class WxInitResponse {
    @JSONField(name = "BaseResponse")
    private WxBaseResponse baseResponse;
    @JSONField(name = "Count")
    private Integer count;
    @JSONField(name = "ContactList")
    private List<WxContact> contactList;
    @JSONField(name = "SyncKey")
    private WxSyncKey syncKey;
    @JSONField(name = "User")
    private WxUser user;
    @JSONField(name = "ChatSet")
    private String chatSet;
    @JSONField(name = "SKey")
    private String sKey;
    @JSONField(name = "ClientVersion")
    private Long clientVersion;
    @JSONField(name= "SystemTime")
    private Long systemTime;
    @JSONField(name = "GrayScale")
    private Integer grayScale;
    @JSONField(name = "InviteStartCount")
    private Integer inviteStartCount;
    @JSONField(name = "MPSubscribeMsgCount")
    private Integer mPSubscribeMsgCount;
    @JSONField(name = "MPSubscribeMsgList")
    private List<WxMPSubscribeMsg> mPSubscribeMsgList;
    @JSONField(name = "ClickReportInterval")
    private Long clickReportInterval;

    public WxBaseResponse getBaseResponse() {
        return baseResponse;
    }

    public void setBaseResponse(WxBaseResponse baseResponse) {
        this.baseResponse = baseResponse;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<WxContact> getContactList() {
        return contactList;
    }

    public void setContactList(List<WxContact> contactList) {
        this.contactList = contactList;
    }

    public WxSyncKey getSyncKey() {
        return syncKey;
    }

    public void setSyncKey(WxSyncKey syncKey) {
        this.syncKey = syncKey;
    }

    public WxUser getUser() {
        return user;
    }

    public void setUser(WxUser user) {
        this.user = user;
    }

    public String getChatSet() {
        return chatSet;
    }

    public void setChatSet(String chatSet) {
        this.chatSet = chatSet;
    }

    public String getsKey() {
        return sKey;
    }

    public void setsKey(String sKey) {
        this.sKey = sKey;
    }

    public Long getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(Long clientVersion) {
        this.clientVersion = clientVersion;
    }

    public Long getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(Long systemTime) {
        this.systemTime = systemTime;
    }

    public Integer getGrayScale() {
        return grayScale;
    }

    public void setGrayScale(Integer grayScale) {
        this.grayScale = grayScale;
    }

    public Integer getInviteStartCount() {
        return inviteStartCount;
    }

    public void setInviteStartCount(Integer inviteStartCount) {
        this.inviteStartCount = inviteStartCount;
    }

    public Integer getmPSubscribeMsgCount() {
        return mPSubscribeMsgCount;
    }

    public void setmPSubscribeMsgCount(Integer mPSubscribeMsgCount) {
        this.mPSubscribeMsgCount = mPSubscribeMsgCount;
    }

    public List<WxMPSubscribeMsg> getmPSubscribeMsgList() {
        return mPSubscribeMsgList;
    }

    public void setmPSubscribeMsgList(List<WxMPSubscribeMsg> mPSubscribeMsgList) {
        this.mPSubscribeMsgList = mPSubscribeMsgList;
    }

    public Long getClickReportInterval() {
        return clickReportInterval;
    }

    public void setClickReportInterval(Long clickReportInterval) {
        this.clickReportInterval = clickReportInterval;
    }
}
