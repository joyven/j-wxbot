package com.joyven.wxbot.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/6
 * Time: 下午6:23
 * Description: 微信订阅号文章
 *
 * @author zhoujunwen
 * @version 1.0
 */
public class WxMPArticle {
    @JSONField(name = "Title")
    private String title;
    @JSONField(name = "Digest")
    private String Digest;
    @JSONField(name = "Cover")
    private String cover;
    @JSONField(name = "Url")
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDigest() {
        return Digest;
    }

    public void setDigest(String digest) {
        Digest = digest;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
