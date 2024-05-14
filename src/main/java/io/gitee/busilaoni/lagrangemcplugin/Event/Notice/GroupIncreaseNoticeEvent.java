package io.gitee.busilaoni.lagrangemcplugin.Event.Notice;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 群成员增加事件
 */
@Data
public class GroupIncreaseNoticeEvent extends NoticeEvent{

    /**
     * 事件子类型，分别表示管理员已同意入群、管理员邀请入群 approve、invite
     */
    @JSONField(name = "sub_type")
    private String subType;

    /**
     * 群号
     */
    @JSONField(name = "group_id")
    private Long groupId;

    /**
     * 操作者QQ号（如果是主动退群，则和 user_id 相同）
     */
    @JSONField(name = "operator_id")
    private Long operatorId;

    /**
     * 	离开者QQ号
     */
    @JSONField(name = "user_id")
    private Long userId;
}
