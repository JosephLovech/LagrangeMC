package io.gitee.busilaoni.lagrangemcplugin.Data;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * ApiRawData 类是API响应的数据模型
 */
@Data
public class ApiRawData {
    /**
     * 状态
     */
    @JSONField(name = "status")
    private String status;

    /**
     * 状态码
     */
    @JSONField(name = "retcode")
    private Integer retcode;

    /**
     * 数据
     */
    @JSONField(name = "data")
    private JSONObject data;
}
