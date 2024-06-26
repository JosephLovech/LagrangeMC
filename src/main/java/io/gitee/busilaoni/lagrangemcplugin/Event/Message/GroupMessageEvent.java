package io.gitee.busilaoni.lagrangemcplugin.Event.Message;

import com.alibaba.fastjson2.annotation.JSONField;
import io.gitee.busilaoni.lagrangemcplugin.Entity.Anonymous;
import io.gitee.busilaoni.lagrangemcplugin.Entity.Sender;
import lombok.Data;

/**
 * 群消息事件
 */
@Data
public class GroupMessageEvent extends MessageEvent{

    /**
     * 消息id
     */
    @JSONField(name = "message_id")
    private Long messageId;

    /**
     * 消息子类型、正常消息是normal、匿名消息是anonymous、系统提示note
     */
    @JSONField(name = "sub_type")
    private String subType;

    /**
     * 群号
     */
    @JSONField(name = "group_id")
    private Long groupId;

    /**
     * 匿名消息，如果没有则为null
     */
    @JSONField(name = "anonymous")
    private Anonymous anonymous;

    /**
     * 消息内容
     */
    @JSONField(name = "message")
    private String message;

    /**
     * 原始消息内容
     */
    @JSONField(name = "raw_message")
    private String raw_message;

    /**
     * 字体
     */
    @JSONField(name = "font")
    private Integer font;

    /**
     * 发送人信息
     */
    @JSONField(name = "sender")
    private Sender sender;
}
