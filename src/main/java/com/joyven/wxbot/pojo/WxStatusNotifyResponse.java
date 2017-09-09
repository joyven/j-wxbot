package com.joyven.wxbot.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/6
 * Time: 下午6:57
 * Description: 状态通知相应消息
 *
 * @author zhoujunwen
 * @version 1.0
 */
public class WxStatusNotifyResponse {
    @JSONField(name = "BaseResponse")
    private WxBaseResponse baseResponse;

    @JSONField(name = "MsgID")
    private String msgId;
}
