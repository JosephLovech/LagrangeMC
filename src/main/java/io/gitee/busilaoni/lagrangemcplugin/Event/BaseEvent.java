package io.gitee.busilaoni.lagrangemcplugin.Event;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 事件公共属性
 */
@Data
public class BaseEvent {

    /**
     * 事件发生的时间戳
     */
    @JSONField(name = "time")
    private Long time;

    /**
     * 收到事件的机器人QQ号
     */
    @JSONField(name = "self_id")
    private Long selfId;

    /**
     * 上报类型
     */
    @JSONField(name = "post_type")
    private String postType;
}
