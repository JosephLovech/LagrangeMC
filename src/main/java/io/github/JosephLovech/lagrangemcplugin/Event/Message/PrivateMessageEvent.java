package io.github.JosephLovech.lagrangemcplugin.Event.Message;

import com.alibaba.fastjson2.annotation.JSONField;
import io.github.JosephLovech.lagrangemcplugin.Event.Sender;
import lombok.Data;

/**
 * 私聊消息事件
 */
@Data
public class PrivateMessageEvent extends MessageEvent{

    /**
     * 消息子类型，如果是好友则是friend,如果是群临时会话则是group
     */
    @JSONField(name = "sub_type")
    private String subType;

    /**
     * 消息内容
     */
    @JSONField(name = "message")
    private String message;

    /**
     * 原始消息内容
     */
    @JSONField(name = "raw_message")
    private String rawMessage;

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
