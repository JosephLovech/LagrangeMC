package io.gitee.busilaoni.lagrangemcplugin.Event.Notice;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 好友消息撤回事件
 */
@Data
public class FriendRecallNoticeEvent extends NoticeEvent{

    /**
     * 	好友QQ号
     */
    @JSONField(name = "user_id")
    private Long userId;

    /**
     * 被撤回的消息ID
     */
    @JSONField(name = "message_id")
    private Long messageId;
}
