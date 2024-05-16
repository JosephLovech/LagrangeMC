package io.gitee.busilaoni.lagrangemcplugin.Data.DataEntity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 群成员的消息数据
 */
@Data
public class GroupMemberInfoData {

    /**
     * 群号
     */
    @JSONField(name = "group_id")
    private Long groupId;

    /**
     * QQ号
     */
    @JSONField(name = "user_id")
    private Long userId;

    /**
     * 昵称
     */
    @JSONField(name = "nickname")
    private String nickname;

    /**
     * 成员备注
     */
    @JSONField(name = "card")
    private String card;

    /**
     * 性别，male或female或unknown
     */
    @JSONField(name = "sex")
    private String sex;

    /**
     * 年龄
     */
    @JSONField(name = "age")
    private Integer age;

    /**
     * 地区
     */
    @JSONField(name = "area")
    private String area;

    /**
     * 加群时间戳
     */
    @JSONField(name = "join_time")
    private Long joinTime;

    /**
     * 最后发言时间戳
     */
    @JSONField(name = "last_sent_time")
    private Long lastSentTime;

    /**
     * 成员等级
     */
    @JSONField(name = "level")
    private String level;

    /**
     * 角色，owner或admin或member
     */
    @JSONField(name = "role")
    private String role;

    /**
     * 是否不良记录成员
     */
    @JSONField(name = "unfriendly")
    private boolean unfriendly;

    /**
     * 专属头衔
     */
    @JSONField(name = "title")
    private String title;

    /**
     * 专属头衔过期时间戳
     */
    @JSONField(name = "title_expire_time")
    private Long titleExpireTime;

    /**
     * 是否允许修改群名片
     */
    @JSONField(name = "card_changeable")
    private boolean cardChangeable;
}
