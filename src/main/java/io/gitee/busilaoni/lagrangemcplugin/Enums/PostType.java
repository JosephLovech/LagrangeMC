package io.gitee.busilaoni.lagrangemcplugin.Enums;

/**
 * 上报数据类型
 */
public enum PostType {

    MESSAGE("message","消息事件上报"),
    META_EVENT("meta_event","元事件上报"),
    NOTICE("notice","通知事件上报"),
    REQUEST("request","请求事件上报");

    /**
     * 发送参数
     */
    private final String action;

    /**
     * 描述
     */
    private final String description;

    /**
     * 构建postType枚举类
     * param action
     * param description
     */
    PostType(String action, String description) {
        this.action = action;
        this.description = description;
    }

    /**
     * 获取发送参数 action
     * return
     */
    public String getAction() {
        return action;
    }

    /**
     * 获取描述 description
     * return
     */
    public String getDescription() {
        return description;
    }
}
