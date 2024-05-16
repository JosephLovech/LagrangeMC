package io.gitee.busilaoni.lagrangemcplugin.Data.DataEntity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 检查是否可发送图片、语音的消息数据
 */
@Data
public class ConformData {

    /**
     * 是与否
     */
    @JSONField(name = "yes")
    private boolean yes;
}
