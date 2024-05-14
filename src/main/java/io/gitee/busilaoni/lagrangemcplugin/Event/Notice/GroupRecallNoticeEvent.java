package io.gitee.busilaoni.lagrangemcplugin.Event.Notice;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 群消息撤回事件
 */
@Data
public class GroupRecallNoticeEvent extends NoticeEvent{

    /**
     * 群号
     */
    @JSONField(name = "group_id")
    private Long groupId;

    /**
     * 	消息发送者QQ号
     */
    @JSONField(name = "user_id")
    private Long userId;

    /**
     * 操作者QQ号
     */
    @JSONField(name = "operator_id")
    private Long operatorId;

    /**
     * 被撤回的消息ID
     */
    @JSONField(name = "message_id")
    private Long messageId;
}
