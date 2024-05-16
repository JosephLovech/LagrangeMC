package io.gitee.busilaoni.lagrangemcplugin.Data.DataEntity;

import com.alibaba.fastjson2.annotation.JSONField;
import io.gitee.busilaoni.lagrangemcplugin.Entity.Sender;
import lombok.Data;

/**
 * api请求返回的消息数据
 */
@Data
public class MessageData {

    /**
     * 发送时间
     */
    @JSONField(name = "time")
    private Long time;

    /**
     * 消息类型，通消息事件
     */
    @JSONField(name = "message_type")
    private String messageType;

    /**
     * 消息ID
     */
    @JSONField(name = "message_id")
    private Long messageId;

    /**
     * 消息真实ID
     */
    @JSONField(name = "real_id")
    private Long realId;

    /**
     * 发送人信息，同消息事件
     */
    @JSONField(name = "sender")
    private Sender sender;

    /**
     * 消息内容
     */
    @JSONField(name = "message")
    private String message;
}
