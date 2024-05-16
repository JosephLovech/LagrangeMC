package io.gitee.busilaoni.lagrangemcplugin.Entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 历史龙王、群聊之火、群聊炽焰、冒尖小竹笋、快乐之源
 */
@Data
public class Current {
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
     * 荣誉描述
     */
    @JSONField(name = "description")
    private String description;
}
