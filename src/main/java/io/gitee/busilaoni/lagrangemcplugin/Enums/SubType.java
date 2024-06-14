package io.gitee.busilaoni.lagrangemcplugin.Enums;

/**
 * 消息子类型
 */
public enum SubType {

    /**
     * 好友
     */
    FRIEND("friend","好友"),

    /**
     * 临时会话
     */
    GROUP("group","临时会话"),

    /**
     * 其他
     */
    OTHER("other","其他"),

    /**
     * 正常消息
     */
    NORMAL("normal","正常消息"),

    /**
     * 匿名消息
     */
    ANONYMOUS("anonymous","匿名消息"),

    /**
     * 系统提示（如「管理员已禁止群内匿名聊天」）
     */
    NOTICE("notice","系统提示（如「管理员已禁止群内匿名聊天」）"),

    /**
     * 群内戳一戳
     */
    POKE("poke","群内戳一戳"),

    /**
     * 群红包运气王
     */
    LUCKY_KING("lucky_king","群红包运气王"),

    /**
     * 群成员荣誉变更
     */
    HONOR("honor","群成员荣誉变更"),

    /**
     * 加群请求
     */
    ADD("add","加群请求"),

    /**
     * 邀请登录号入群
     */
    INVITE("invite","邀请登录号入群");


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
    SubType(String action, String description) {
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
