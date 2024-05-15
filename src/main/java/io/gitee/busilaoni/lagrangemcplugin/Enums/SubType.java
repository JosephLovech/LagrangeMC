package io.gitee.busilaoni.lagrangemcplugin.Enums;

/**
 * 消息子类型
 */
public enum SubType {

    FRIEND("friend","好友"),
    GROUP("group","临时会话"),
    OTHER("other","其他"),
    NORMAL("normal","正常消息"),
    ANONYMOUS("anonymous","匿名消息"),
    NOTICE("notice","系统提示（如「管理员已禁止群内匿名聊天」）"),
    POKE("poke","群内戳一戳"),
    LUCKY_KING("lucky_king","群红包运气王"),
    HONOR("honor","群成员荣誉变更"),
    ADD("add","加群请求"),
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
     * param action
     * param description
     */
    SubType(String action, String description) {
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
