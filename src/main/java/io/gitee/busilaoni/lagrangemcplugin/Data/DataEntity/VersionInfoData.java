package io.gitee.busilaoni.lagrangemcplugin.Data.DataEntity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 获取运行状态的消息数据
 */
@Data
public class VersionInfoData {

    /**
     * 应用标识，如mirai-native
     */
    @JSONField(name = "app_name")
    private String appName;

    /**
     * 应用版本，如1.2.3
     */
    @JSONField(name = "app_version")
    private String appVersion;

    /**
     * OneBot 标准版本，如v11
     */
    @JSONField(name = "protocol_version")
    private String protocolVersion;
}
