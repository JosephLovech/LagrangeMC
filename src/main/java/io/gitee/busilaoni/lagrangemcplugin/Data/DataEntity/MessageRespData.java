package io.gitee.busilaoni.lagrangemcplugin.Data.DataEntity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * api发送消息的数据
 */
@Data
public class MessageRespData {

    /**
     * 消息ID
     */
    @JSONField(name = "message_id")
    private Long messageId;
}
