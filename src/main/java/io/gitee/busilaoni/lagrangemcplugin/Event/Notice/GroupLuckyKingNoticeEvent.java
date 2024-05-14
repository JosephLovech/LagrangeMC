package io.gitee.busilaoni.lagrangemcplugin.Event.Notice;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 红包运气王事件
 */
@Data
public class GroupLuckyKingNoticeEvent {
    /**
     * 消息类型 lucky_king
     */
    @JSONField(name = "sub_type")
    private String subType;

    /**
     * 群号
     */
    @JSONField(name = "group_id")
    private Long groupId;

    /**
     * 	发送红包者QQ号
     */
    @JSONField(name = "user_id")
    private Long userId;

    /**
     * 运气王QQ号
     */
    @JSONField(name = "target_id")
    private Long targetId;


}
