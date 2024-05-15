package io.gitee.busilaoni.lagrangemcplugin.Enums;

/**
 * 通知事件
 */
public enum NoticeType {

    GROUP_UPLOAD("group_upload","群文件上传"),
    GROUP_ADMIN("group_admin","群管理员变动"),
    GROUP_DECREASE("group_decrease","群成员减少"),
    GROUP_INCREASE("group_increase","群成员增加"),
    GROUP_BAN("group_ban","群禁言"),
    FRIEND_ADD("friend_add","好友添加"),
    GROUP_RECALL("group_recall","群消息撤回"),
    FRIEND_RECALL("friend_recall","好友消息撤回"),
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
     * param action
     * param description
     */
    NoticeType(String action, String description) {
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
