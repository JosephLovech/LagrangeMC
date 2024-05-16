package io.gitee.busilaoni.lagrangemcplugin.Data.DataEntity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 群信息的消息数据
 */
@Data
public class GroupInfoData {

    /**
     * 群号
     */
    @JSONField(name = "group_id")
    private Long groupId;

    /**
     * 群名称
     */
    @JSONField(name = "group_name")
    private String groupName;

    /**
     * 成员数
     */
    @JSONField(name = "member_count")
    private Integer memberCount;

    /**
     * 最大成员数
     */
    @JSONField(name = "max_member_count")
    private Integer maxMemberCount;
}
