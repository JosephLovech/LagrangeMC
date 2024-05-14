package io.gitee.busilaoni.lagrangemcplugin.Event.Request;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 加群请求/邀请
 */
@Data
public class GroupRequestEvent extends RequestEvent{

    /**
     * 请求子类型，分别表示加群请求、邀请登录号入群 add、invite
     */
    @JSONField(name = "sub_type")
    private String subType;

    /**
     * 群号
     */
    @JSONField(name = "group_id")
    private Long groupId;

    /**
     * 发送请求的QQ号
     */
    @JSONField(name = "user_id")
    private Long userId;

    /**
     * 验证信息
     */
    @JSONField(name = "comment")
    private String comment;

    /**
     * 请求 flag，在调用处理请求的API时需要传入
     */
    @JSONField(name = "flag")
    private String flag;
}
