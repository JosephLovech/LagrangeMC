package io.gitee.busilaoni.lagrangemcplugin.Enums;

/**
 * 元事件类型
 */
public enum MetaEventType {

    LIFECYCLE("lifecycle","生命周期"),
    HEARTBEAT("heartbeat","心跳");


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
    MetaEventType(String action, String description) {
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
