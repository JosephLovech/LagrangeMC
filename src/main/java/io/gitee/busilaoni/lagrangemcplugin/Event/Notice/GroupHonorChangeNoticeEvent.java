package io.gitee.busilaoni.lagrangemcplugin.Event.Notice;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 群成员荣誉变更事件
 */
@Data
public class GroupHonorChangeNoticeEvent {

    /**
     * 提示类型 honor
     */
    @JSONField(name = "sub_type")
    private String subType;

    /**
     * 群号
     */
    @JSONField(name = "group_id")
    private Long groupId;

    /**
     * 荣誉类型，分别表示龙王、群聊之火、快乐源泉 talkative、performer、emotion
     */
    @JSONField(name = "honor_type")
    private String honorType;

    /**
     * 成员QQ号
     */
    @JSONField(name = "user_id")
    private Long userId;
}
