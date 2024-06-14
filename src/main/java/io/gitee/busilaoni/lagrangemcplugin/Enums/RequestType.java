package io.gitee.busilaoni.lagrangemcplugin.Enums;

/**
 * 请求类型
 */
public enum RequestType {

    /**
     * 加好友请求
     */
    FRIEND("friend","加好友请求"),

    /**
     * 加群请求/邀请
     */
    GROUP("group","加群请求/邀请");

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
    RequestType(String action, String description) {
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
