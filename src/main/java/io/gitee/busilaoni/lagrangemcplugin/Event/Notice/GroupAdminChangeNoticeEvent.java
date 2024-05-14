package io.gitee.busilaoni.lagrangemcplugin.Event.Notice;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 群管理员变动事件
 */
@Data
public class GroupAdminChangeNoticeEvent extends NoticeEvent{

    /**
     * 事件子类型，分别表示设置和取消管理员 set、unset
     */
    @JSONField(name = "sub_type")
    private String subType;

    /**
     * 群号
     */
    @JSONField(name = "group_id")
    private Long groupId;

    /**
     * 管理员QQ号
     */
    @JSONField(name = "user_id")
    private Long userId;
}
