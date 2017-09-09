package com.joyven.wxbot.message.vo;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/8
 * Time: 下午5:37
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
public enum MsgType {
    TEXT(1),      // 文本消息
    IMAGE(3),     // 3	图片消息
    VIOCE(34),          //	语音消息
    FRIDEN_CONFIRM(37), //	好友确认消息
    POSSIBLEFRIEND(40), //	POSSIBLEFRIEND_MSG
    SHARE_MP(42), //	共享名片
    VIDEO(43),    //	视频消息
    EMOTION(47),//动画表情
    LOCATION(48), //位置消息
    SHARE_LINK(49),// 分享链接
    VOIP(50),// VOIPMSG
    INIT(51), // 微信初始化消息
    VOIPNOTIFY(52), // VOIPNOTIFY
    VOIPINVITE(53), // VOIPINVITE
    SHORT_VIDEO(62), // 小视频
    SYSNOTICE(9999), // SYSNOTICE
    SYS(10000), // 系统消息
    REVOKE(10002); //撤回消息
    private Integer type;

    MsgType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}
