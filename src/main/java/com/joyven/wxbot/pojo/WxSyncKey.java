package com.joyven.wxbot.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/6
 * Time: 下午6:10
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
public class WxSyncKey {
    @JSONField(name = "Count")
    private Integer count;
    @JSONField(name = "List")
    private List<WxSyncKeyValue> list;
}
