package io.gitee.busilaoni.lagrangemcplugin.Data.DataEntity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 获取cookies的消息数据
 */
@Data
public class CookiesData {

    /**
     * Cookies
     */
    @JSONField(name = "cookies")
    private String cookies;
}
