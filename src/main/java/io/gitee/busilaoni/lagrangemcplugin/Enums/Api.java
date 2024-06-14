package io.gitee.busilaoni.lagrangemcplugin.Enums;

/**
 * api枚举类
 */
public enum Api {

    /**
     * 发送私聊信息
     */
    SEND_PRIVATE_MSG("send_private_msg","发送私聊信息"),

    /**
     * 发送群信息
     */
    SEND_GROUP_MSG("send_group_msg","发送群信息"),

    /**
     * 发送消息
     */
    SEND_MSG("send_msg","发送消息"),

    /**
     * 撤回消息
     */
    DELETE_MSG("delete_msg","撤回消息"),

    /**
     * 获取消息
     */
    GET_MSG("get_msg","获取消息"),

    /**
     * 获取合并转发消息
     */
    GET_FORWARD_MSG("get_forward_msg","获取合并转发消息"),

    /**
     * 发送好友赞
     */
    SEND_LIKE("send_like","发送好友赞"),

    /**
     * 群组踢人
     */
    SET_GROUP_KICK("set_group_kick","群组踢人"),

    /**
     * 群组单人禁言
     */
    SET_GROUP_BAN("set_group_ban","群组单人禁言"),

    /**
     * 群组匿名用户禁言
     */
    SET_GROUP_ANONYMOUS_BAN("set_group_anonymous_ban","群组匿名用户禁言"),

    /**
     * 群组全员禁言
     */
    SET_GROUP_WHOLE_BAN("set_group_whole_ban","群组全员禁言"),

    /**
     * 群组设置管理员
     */
    SET_GROUP_ADMIN("set_group_admin","群组设置管理员"),

    /**
     * 群组匿名
     */
    SET_GROUP_ANONYMOUS("set_group_anonymous","群组匿名"),

    /**
     * 设置群名片(群备注)
     */
    SET_GROUP_CARD("set_group_card","设置群名片(群备注)"),

    /**
     * 设置群名
     */
    SET_GROUP_NAME("set_group_name","设置群名"),

    /**
     * 退出群组
     */
    SET_GROUP_LEAVE("set_group_leave","退出群组"),

    /**
     * 设置群组专属头衔
     */
    SET_GROUP_SPECIAL_TITLE("set_group_special_title","设置群组专属头衔"),

    /**
     * 处理加好友请求
     */
    SET_FRIEND_ADD_REQUEST("set_friend_add_request","处理加好友请求"),

    /**
     * 处理加群请求/邀请
     */
    SET_GROUP_ADD_REQUEST("set_group_add_request","处理加群请求/邀请"),

    /**
     * 获取登录号信息
     */
    GET_LOGIN_INFO("get_login_info","获取登录号信息"),

    /**
     * 获取陌生人信息
     */
    GET_STRANGER_INFO("get_stranger_info","获取陌生人信息"),

    /**
     * 获取好友列表
     */
    GET_FRIEND_LIST("get_friend_list","获取好友列表"),

    /**
     * 获取群信息
     */
    GET_GROUP_INFO("get_group_info","获取群信息"),

    /**
     * 获取群列表
     */
    GET_GROUP_List("get_group_list","获取群列表"),

    /**
     * 获取群成员信息
     */
    GET_GROUP_MEMBER_INFO("get_group_member_info","获取群成员信息"),

    /**
     * 获取群成员列表
     */
    GET_GROUP_MEMBER_LIST("get_group_member_list","获取群成员列表"),

    /**
     * 获取群荣誉信息
     */
    GET_GROUP_HONOR_INFO("get_group_honor_info","获取群荣誉信息"),

    /**
     * 获取Cookies
     */
    GET_COOKIES("get_cookies","获取Cookies"),

    /**
     * 获取CSRF Token
     */
    GET_CSRF_TOKEN("get_csrf_token","获取CSRF Token"),

    /**
     * 获取QQ相关接口凭证
     */
    GET_CREDENTIALS("get_credentials","获取QQ相关接口凭证"),

    /**
     * 获取语音
     */
    GET_RECORD("get_record","获取语音"),

    /**
     * 获取图片
     */
    GET_IMAGE("get_image","获取图片"),

    /**
     * 检查是否可以发送图片
     */
    CAN_SEND_IMAGE("can_send_image","检查是否可以发送图片"),

    /**
     * 检查是否可以发送语音
     */
    CAN_SEND_RECORD("can_send_record","检查是否可以发送语音"),

    /**
     * 获取运行状态
     */
    GET_STATUS("get_status","获取运行状态"),

    /**
     * 重启OneBot实现
     */
    SET_RESTART("set_restart","重启OneBot实现"),

    /**
     * 获取版本信息
     */
    GET_VERSION_INFO("get_version_info","获取版本信息"),

    /**
     * 清理缓存
     */
    CLEAN_CACHE("clean_cache","清理缓存"),;


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
     *
     * @param action api类型
     * @param description 描述信息
     */
    Api(String action, String description) {
        this.action = action;
        this.description = description;
    }

    /**
     * 获取发送参数 action
     *
     * @return 返回api类型
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
