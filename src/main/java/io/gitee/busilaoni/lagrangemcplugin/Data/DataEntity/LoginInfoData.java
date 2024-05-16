package io.gitee.busilaoni.lagrangemcplugin.Data.DataEntity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 获取登录号信息的消息回复
 */
@Data
public class LoginInfoData {

    /**
     * QQ号
     */
    @JSONField(name = "user_id")
    private Long userId;

    /**
     * QQ昵称
     */
    @JSONField(name = "nickname")
    private String nickname;
}
