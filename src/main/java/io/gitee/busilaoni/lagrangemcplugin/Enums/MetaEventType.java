package io.gitee.busilaoni.lagrangemcplugin.Enums;

/**
 * 元事件类型
 */
public enum MetaEventType {

    /**
     * 生命周期
     */
    LIFECYCLE("lifecycle","生命周期"),

    /**
     * 心跳
     */
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
     *
     * @param action postType类型
     * @param description 描述信息
     */
    MetaEventType(String action, String description) {
        this.action = action;
        this.description = description;
    }

    /**
     * 获取发送参数 action
     *
     * @return 返回postType类型
     */
    public String getAction() {
        return action;
    }

    /**
     * 获取描述 description
     *
     * @return 返回描述信息
     */
    public String getDescription() {
        return description;
    }
}
