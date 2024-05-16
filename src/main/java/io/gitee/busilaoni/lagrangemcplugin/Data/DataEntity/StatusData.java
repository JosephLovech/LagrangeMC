package io.gitee.busilaoni.lagrangemcplugin.Data.DataEntity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 获取运行状态的消息数据
 */
@Data
public class StatusData {

    /**
     * 当前 QQ 在线，null 表示无法查询到在线状态
     */
    @JSONField(name = "online")
    private boolean online;

    /**
     * 状态符合预期，意味着各模块正常运行、功能正常，且 QQ 在线
     */
    @JSONField(name = "good")
    private boolean good;
}
