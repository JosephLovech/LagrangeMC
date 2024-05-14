package io.gitee.busilaoni.lagrangemcplugin.Event.Notice;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 好友添加事件
 */
@Data
public class FriendAddNoticeEvent extends NoticeEvent{

    /**
     * 新添加好友QQ号
     */
    @JSONField(name = "user_id")
    private Long userId;
}
