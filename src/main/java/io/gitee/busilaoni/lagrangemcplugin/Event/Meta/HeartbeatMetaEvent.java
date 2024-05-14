package io.gitee.busilaoni.lagrangemcplugin.Event.Meta;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 心跳事件
 */
@Data
public class HeartbeatMetaEvent extends MetaEvent{

    /**
     * 状态信息
     */
    @JSONField(name = "status")
    private String status;

    /**
     * 到下次心跳的间隔，单位毫秒
     */
    @JSONField(name = "interval")
    private Long interval;
}
