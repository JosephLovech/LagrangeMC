package io.gitee.busilaoni.lagrangemcplugin.Event.Meta;

import com.alibaba.fastjson2.annotation.JSONField;
import io.gitee.busilaoni.lagrangemcplugin.Event.BaseEvent;
import lombok.Data;

/**
 * 元事件
 */
@Data
public class MetaEvent extends BaseEvent {

    /**
     * 元事件类型 lifecycle
     */
    @JSONField(name = "meta_event_type")
    private String metaEventType;
}
