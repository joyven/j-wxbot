package com.joyven.wxbot.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Date: 2017/9/8
 * Time: 下午4:48
 * Description:
 *
 * @author zhoujunwen
 * @version 1.0
 */
public class WxContactResponse {
    @JSONField(name = "BaseResponse")
    private WxBaseResponse baseResponse;
    @JSONField(name = "MemberCount")
    private Integer memberCount;
    @JSONField(name = "MemberList")
    private List<WxContact> memberList;

    public WxBaseResponse getBaseResponse() {
        return baseResponse;
    }

    public void setBaseResponse(WxBaseResponse baseResponse) {
        this.baseResponse = baseResponse;
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

    public List<WxContact> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<WxContact> memberList) {
        this.memberList = memberList;
    }
}
