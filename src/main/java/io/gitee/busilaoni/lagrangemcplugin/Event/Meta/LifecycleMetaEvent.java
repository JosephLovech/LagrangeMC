package io.gitee.busilaoni.lagrangemcplugin.Event.Meta;

import com.alibaba.fastjson2.annotation.JSONField;
import io.gitee.busilaoni.lagrangemcplugin.Event.BaseEvent;
import lombok.Data;

/**
 * 生命周期事件
 */
@Data
public class LifecycleMetaEvent extends MetaEvent {

    /**
     * 事件子类型，分别表示 OneBot启用、停用、WebSocket连接成功 enable、disable、connect
     */
    @JSONField(name = "sub_type")
    private String subType;
}
