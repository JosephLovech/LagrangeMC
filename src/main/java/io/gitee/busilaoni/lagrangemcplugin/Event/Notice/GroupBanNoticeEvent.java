package io.gitee.busilaoni.lagrangemcplugin.Event.Notice;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * 群禁言事件
 */
public class GroupBanNoticeEvent {

    /**
     * 事件子类型，分别表示设置和取消管理员
     */
    @JSONField(name = "sub_type")
    private String subType;

    /**
     * 群号
     */
    @JSONField(name = "group_id")
    private Long groupId;

    /**
     * 操作者QQ号
     */
    @JSONField(name = "operator_id")
    private Long operatorId;

    /**
     * 	被禁言QQ号
     */
    @JSONField(name = "user_id")
    private Long userId;

    /**
     * 	禁言时长，单位秒
     */
    @JSONField(name = "duration")
    private Long duration;
}
