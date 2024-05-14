package io.gitee.busilaoni.lagrangemcplugin.Event.Notice;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 群内戳一戳事件
 */
@Data
public class GroupPokeNoticeEvent extends NoticeEvent{

    /**
     * 	提示类型 poke
     */
    @JSONField(name = "sub_type")
    private String subType;

    /**
     * 	群号
     */
    @JSONField(name = "group_id")
    private Long groupId;

    /**
     * 	消息发送者QQ号
     */
    @JSONField(name = "user_id")
    private Long userId;

    /**
     * 	被戳者QQ号
     */
    @JSONField(name = "target_id")
    private Long targetId;
}
