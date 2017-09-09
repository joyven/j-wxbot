package com.joyven.wxbot.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/6
 * Time: 下午6:12
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
public class WxSyncKeyValue {
    @JSONField(name = "Key")
    private String key;
    @JSONField(name = "Val")
    private Long val;
}
