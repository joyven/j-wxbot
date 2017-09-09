package com.joyven.wxbot.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/6
 * Time: 下午6:22
 * Description: 微信订阅号消息
 *
 * @author zhoujunwen
 * @version 1.0
 */
public class WxMPSubscribeMsg {
    @JSONField(name = "UserName")
    private String userName;
    @JSONField(name = "MPArticleCount")
    private Integer mPArticleCount;
    @JSONField(name = "MPArticleList")
    private List<WxMPArticle> mPArticleList;
    @JSONField(name = "Time")
    private Long time;
    @JSONField(name = "NickName")
    private String nickName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getmPArticleCount() {
        return mPArticleCount;
    }

    public void setmPArticleCount(Integer mPArticleCount) {
        this.mPArticleCount = mPArticleCount;
    }

    public List<WxMPArticle> getmPArticleList() {
        return mPArticleList;
    }

    public void setmPArticleList(List<WxMPArticle> mPArticleList) {
        this.mPArticleList = mPArticleList;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
