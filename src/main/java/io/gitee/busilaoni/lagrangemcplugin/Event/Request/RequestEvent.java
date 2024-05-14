package io.gitee.busilaoni.lagrangemcplugin.Event.Request;

import com.alibaba.fastjson2.annotation.JSONField;
import io.gitee.busilaoni.lagrangemcplugin.Event.BaseEvent;
import lombok.Data;

/**
 * 请求事件
 */
@Data
public class RequestEvent extends BaseEvent {

    /**
     * 请求类型 group、friend
     */
    @JSONField(name = "request_type")
    private String requestType;
}
