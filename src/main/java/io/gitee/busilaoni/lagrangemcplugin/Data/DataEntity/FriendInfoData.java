package io.gitee.busilaoni.lagrangemcplugin.Data.DataEntity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 好友信息的消息数据
 */
@Data
public class FriendInfoData {

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
     * 备注名
     */
    @JSONField(name = "remark")
    private String remark;
}
