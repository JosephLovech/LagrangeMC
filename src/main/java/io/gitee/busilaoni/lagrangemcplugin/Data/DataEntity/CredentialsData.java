package io.gitee.busilaoni.lagrangemcplugin.Data.DataEntity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 获取QQ相关接口凭证的消息数据
 */
@Data
public class CredentialsData {

    /**
     * Cookies
     */
    @JSONField(name = "cookies")
    private String cookies;

    /**
     * CSRFToken
     */
    @JSONField(name = "csrf_token")
    private Integer csrfToken;
}
