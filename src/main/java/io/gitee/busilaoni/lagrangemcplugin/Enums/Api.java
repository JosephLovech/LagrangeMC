package io.gitee.busilaoni.lagrangemcplugin.Enums;

/**
 * api枚举类
 */
public enum Api {

    SEND_PRIVATE_MSG("send_private_msg","发送私聊信息"),
    SEND_GROUP_MSG("send_group_msg","发送群信息"),
    SEND_MSG("send_msg","发送消息"),
    DELETE_MSG("delete_msg","撤回消息"),
    GET_MSG("get_msg","获取消息"),
    GET_FORWARD_MSG("get_forward_msg","获取合并转发消息"),
    SEND_LIKE("send_like","发送好友赞"),
    SET_GROUP_KICK("set_group_kick","群组踢人"),
    SET_GROUP_BAN("set_group_ban","群组单人禁言"),
    SET_GROUP_ANONYMOUS_BAN("set_group_anonymous_ban","群组匿名用户禁言"),
    SET_GROUP_WHOLE_BAN("set_group_whole_ban","群组全员禁言"),
    SET_GROUP_ADMIN("set_group_admin","群组设置管理员");


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
