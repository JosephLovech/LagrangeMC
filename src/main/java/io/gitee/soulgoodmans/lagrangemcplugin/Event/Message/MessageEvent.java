package io.gitee.soulgoodmans.lagrangemcplugin.Event.Message;

import com.alibaba.fastjson2.annotation.JSONField;
import io.gitee.soulgoodmans.lagrangemcplugin.Event.BaseEvent;
import lombok.Data;

/**
 * 消息事件
 */
@Data
public class MessageEvent extends BaseEvent {

    /**
     * 消息类型 private group
     */
    @JSONField(name = "message_type")
    private String messageType;

    /**
     * 消息id
     */
    @JSONField(name = "message_id")
    private Long MessageId;

    /**
     * 发送者QQ号
     */
    @JSONField(name = "user_id")
    private Long userId;
}
