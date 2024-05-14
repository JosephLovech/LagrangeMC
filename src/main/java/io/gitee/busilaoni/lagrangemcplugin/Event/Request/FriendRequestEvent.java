package io.gitee.busilaoni.lagrangemcplugin.Event.Request;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 加好友请求事件
 */
@Data
public class FriendRequestEvent extends RequestEvent{

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
