package io.gitee.busilaoni.lagrangemcplugin.Enums;

/**
 * 群荣誉类型
 */
public enum HonorType {

    TALK_ACTIVE("talkactive","龙王"),
    PERFORMER("performer","群聊之火"),
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
     * param action
     * param description
     */
    HonorType(String action, String description) {
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
