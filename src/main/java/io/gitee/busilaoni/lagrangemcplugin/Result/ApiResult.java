package io.gitee.busilaoni.lagrangemcplugin.Result;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.util.Map;

@Data
public class ApiResult {

    /**
     * api枚举中action
     */
    @JSONField(name = "action")
    private String action;

    /**
     * params内容
     */
    @JSONField(name = "params")
    private Map params;
}
