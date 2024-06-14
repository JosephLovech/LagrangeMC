package io.gitee.busilaoni.lagrangemcplugin.Enums;

/**
 * 通知事件
 */
public enum NoticeType {

    /**
     * 群文件上传
     */
    GROUP_UPLOAD("group_upload","群文件上传"),

    /**
     * 群管理员变动
     */
    GROUP_ADMIN("group_admin","群管理员变动"),

    /**
     * 群成员减少
     */
    GROUP_DECREASE("group_decrease","群成员减少"),

    /**
     * 群成员增加
     */
    GROUP_INCREASE("group_increase","群成员增加"),

    /**
     * 群禁言
     */
    GROUP_BAN("group_ban","群禁言"),

    /**
     * 好友添加
     */
    FRIEND_ADD("friend_add","好友添加"),

    /**
     * 群消息撤回
     */
    GROUP_RECALL("group_recall","群消息撤回"),

    /**
     * 好友消息撤回
     */
    FRIEND_RECALL("friend_recall","好友消息撤回"),

    /**
     * 通知
     */
    NOTIFY("notify","通知");

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
    NoticeType(String action, String description) {
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
