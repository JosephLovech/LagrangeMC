package io.github.JosephLovech.lagrangemcplugin.Enums;

/**
 * api枚举类
 */
public enum Api {

    SEND_PRIVATE_MSG("send_private_msg","发送私聊信息"),
    SEND_GROUP_MSG("send_group_msg","发送群信息");

    /**
     * 发送参数
     */
    private final String action;

    /**
     * 描述
     */
    private final String description;

    /**
     * 构建api枚举类
     * param action
     * param description
     */
    Api(String action, String description) {
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
