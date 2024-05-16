package io.gitee.busilaoni.lagrangemcplugin.Data.DataEntity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 获取CSRFToken的消息数据
 */
@Data
public class CSRFTokenData {

    /**
     * CSRFToken
     */
    @JSONField(name = "token")
    private String token;
}
