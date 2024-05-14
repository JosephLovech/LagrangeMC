package io.gitee.busilaoni.lagrangemcplugin.Event.Notice;

import com.alibaba.fastjson2.annotation.JSONField;
import io.gitee.busilaoni.lagrangemcplugin.Event.BaseEvent;
import lombok.Data;

/**
 * 通知事件
 */
@Data
public class NoticeEvent extends BaseEvent {

    /**
     * 元事件类型 lifecycle
     */
    @JSONField(name = "notice_type")
    private String noticeType;
}
