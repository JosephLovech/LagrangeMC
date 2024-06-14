package io.gitee.busilaoni.lagrangemcplugin.Enums;

/**
 * 群荣誉类型
 */
public enum HonorType {

    /**
     * 龙王
     */
    TALK_ACTIVE("talkactive","龙王"),

    /**
     * 群聊之火
     */
    PERFORMER("performer","群聊之火"),

    /**
     * 快乐源泉
     */
    EMOTION("emotion","快乐源泉");

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
    HonorType(String action, String description) {
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
