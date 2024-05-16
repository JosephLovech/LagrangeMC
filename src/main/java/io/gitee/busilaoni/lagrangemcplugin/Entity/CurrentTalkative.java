package io.gitee.busilaoni.lagrangemcplugin.Entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 龙王
 */
@Data
public class CurrentTalkative {

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
     * 头像URL
     */
    @JSONField(name = "avatar")
    private String avatar;

    /**
     * 持续天数
     */
    @JSONField(name = "day_count")
    private Integer dayCount;
}
