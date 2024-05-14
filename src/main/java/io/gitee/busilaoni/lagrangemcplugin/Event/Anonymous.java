package io.gitee.busilaoni.lagrangemcplugin.Event;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.ToString;

/**
 * 匿名消息
 */
@Data
@ToString
public class Anonymous {

    /**
     * 匿名用户ID
     */
    @JSONField(name = "id")
    private Long id;

    /**
     * 匿名用户名称
     */
    @JSONField(name = "name")
    private String name;

    /**
     * 匿名用户flag，在调用禁言API时需要传入
     */
    @JSONField(name = "flag")
    private String flag;
}
