package io.gitee.busilaoni.lagrangemcplugin.Bot;


import io.gitee.busilaoni.lagrangemcplugin.Event.Message.GroupMessageEvent;
import io.gitee.busilaoni.lagrangemcplugin.Event.Message.PrivateMessageEvent;
import io.gitee.busilaoni.lagrangemcplugin.Event.Meta.HeartbeatMetaEvent;
import io.gitee.busilaoni.lagrangemcplugin.Event.Meta.LifecycleMetaEvent;
import io.gitee.busilaoni.lagrangemcplugin.Event.Notice.*;
import io.gitee.busilaoni.lagrangemcplugin.Event.Request.FriendRequestEvent;
import io.gitee.busilaoni.lagrangemcplugin.Event.Request.GroupRequestEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象类BotPlugin 插件实现继承自它
 */
public abstract class BotPlugin {

    /**
     * 插件列表
     */
    public static List<Class<? extends BotPlugin>> pluginList = new ArrayList<>();

    /**
     * 收到私聊消息时调用此方法
     *
     * @param bot 机器人实例
     * @param event 事件内容
     * @return 消息是否处理完毕,`MatchedAndBlock`表示处理完毕不继续下一个插件处理,`NotMatch`表示未处理并继续下一个插件处理
     */
    public int onPrivateMessage(Bot bot, PrivateMessageEvent event) {
        return NotMatch;
    }


    /**
     * 收到群消息时调用此方法
     *
     * @param bot 机器人实例
     * @param event 事件内容
     * @return 消息是否处理完毕,`MatchedAndBlock`表示处理完毕不继续下一个插件处理,`NotMatch`表示未处理并继续下一个插件处理
     */
    public int onGroupMessage(Bot bot,GroupMessageEvent event) {
        return NotMatch;
    }

    /**
     * 收到群文件上传时调用此方法
     *
     * @param bot 机器人实例
     * @param event 事件内容
     * @return 消息是否处理完毕,`MatchedAndBlock`表示处理完毕不继续下一个插件处理,`NotMatch`表示未处理并继续下一个插件处理
     */
    public int onGroupFileUpload(Bot bot,GroupFileUploadNoticeEvent event) {
        return NotMatch;
    }

    /**
     * 收到群管理员变更时调用此方法
     *
     * @param bot 机器人实例
     * @param event 事件内容
     * @return 消息是否处理完毕,`MatchedAndBlock`表示处理完毕不继续下一个插件处理,`NotMatch`表示未处理并继续下一个插件处理
     */
    public int onGroupAdminChange(Bot bot,GroupAdminChangeNoticeEvent event) {
        return NotMatch;
    }

    /**
     * 收到群成员减少时调用此方法
     *
     * @param bot 机器人实例
     * @param event 事件内容
     * @return 消息是否处理完毕,`MatchedAndBlock`表示处理完毕不继续下一个插件处理,`NotMatch`表示未处理并继续下一个插件处理
     */
    public int onGroupDecrease(Bot bot,GroupDecreaseNoticeEvent event) {
        return NotMatch;
    }

    /**
     * 收到群成员增加时调用此方法
     *
     * @param bot 机器人实例
     * @param event 事件内容
     * @return 消息是否处理完毕,`MatchedAndBlock`表示处理完毕不继续下一个插件处理,`NotMatch`表示未处理并继续下一个插件处理
     */
    public int onGroupIncrease(Bot bot,GroupIncreaseNoticeEvent event) {
        return NotMatch;
    }

    /**
     * 收到群禁言时调用此方法
     *
     * @param bot 机器人实例
     * @param event 事件内容
     * @return 消息是否处理完毕,`MatchedAndBlock`表示处理完毕不继续下一个插件处理,`NotMatch`表示未处理并继续下一个插件处理
     */
    public int onGroupBan(Bot bot,GroupBanNoticeEvent event) {
        return NotMatch;
    }

    /**
     * 收到好友添加请求时调用此方法
     *
     * @param bot 机器人实例
     * @param event 事件内容
     * @return 消息是否处理完毕,`MatchedAndBlock`表示处理完毕不继续下一个插件处理,`NotMatch`表示未处理并继续下一个插件处理
     */
    public int onFriendAdd(Bot bot,FriendAddNoticeEvent event) {
        return NotMatch;
    }

    /**
     * 收到群消息撤回时调用此方法
     *
     * @param bot 机器人实例
     * @param event 事件内容
     * @return 消息是否处理完毕,`MatchedAndBlock`表示处理完毕不继续下一个插件处理,`NotMatch`表示未处理并继续下一个插件处理
     */
    public int onGroupRecall(Bot bot,GroupRecallNoticeEvent event) {
        return NotMatch;
    }

    /**
     * 收到好友消息撤回时调用此方法
     *
     * @param bot 机器人实例
     * @param event 事件内容
     * @return 消息是否处理完毕,`MatchedAndBlock`表示处理完毕不继续下一个插件处理,`NotMatch`表示未处理并继续下一个插件处理
     */
    public int onFriendRecall(Bot bot,FriendRecallNoticeEvent event) {
        return NotMatch;
    }

    /**
     * 收到群内戳一戳时调用此方法
     *
     * @param bot 机器人实例
     * @param event 事件内容
     * @return 消息是否处理完毕,`MatchedAndBlock`表示处理完毕不继续下一个插件处理,`NotMatch`表示未处理并继续下一个插件处理
     */
    public int onGroupPoke(Bot bot,GroupPokeNoticeEvent event) {
        return NotMatch;
    }

    /**
     * 收到群红包运气王时调用此方法
     *
     * @param bot 机器人实例
     * @param event 事件内容
     * @return 消息是否处理完毕,`MatchedAndBlock`表示处理完毕不继续下一个插件处理,`NotMatch`表示未处理并继续下一个插件处理
     */
    public int onGroupLuckKing(Bot bot,GroupLuckyKingNoticeEvent event) {
        return NotMatch;
    }

    /**
     * 收到群成员荣誉变更时调用此方法
     *
     * @param bot 机器人实例
     * @param event 事件内容
     * @return 消息是否处理完毕,`MatchedAndBlock`表示处理完毕不继续下一个插件处理,`NotMatch`表示未处理并继续下一个插件处理
     */
    public int onGroupHonorChange(Bot bot,GroupHonorChangeNoticeEvent event) {
        return NotMatch;
    }

    /**
     * 收到加好友请求时调用此方法
     *
     * @param bot 机器人实例
     * @param event 事件内容
     * @return 消息是否处理完毕,`MatchedAndBlock`表示处理完毕不继续下一个插件处理,`NotMatch`表示未处理并继续下一个插件处理
     */
    public int onFriendRequest(Bot bot,FriendRequestEvent event) {
        return NotMatch;
    }

    /**
     * 收到加群请求／邀请时调用此方法
     *
     * @param bot 机器人实例
     * @param event 事件内容
     * @return 消息是否处理完毕,`MatchedAndBlock`表示处理完毕不继续下一个插件处理,`NotMatch`表示未处理并继续下一个插件处理
     */
    public int onGroupRequest(Bot bot,GroupRequestEvent event) {
        return NotMatch;
    }

    /**
     * 收到生命周期时调用此方法
     *
     * @param bot 机器人实例
     * @param event 事件内容
     * @return 消息是否处理完毕,`MatchedAndBlock`表示处理完毕不继续下一个插件处理,`NotMatch`表示未处理并继续下一个插件处理
     */
    public int onLifecycleMeta(Bot bot,LifecycleMetaEvent event) {
        return NotMatch;
    }

    /**
     * 收到心跳时调用此方法
     *
     * @param bot 机器人实例
     * @param event 事件内容
     * @return 消息是否处理完毕,`MatchedAndBlock`表示处理完毕不继续下一个插件处理,`NotMatch`表示未处理并继续下一个插件处理
     */
    public int onHeartbeatMeta(Bot bot,HeartbeatMetaEvent event) {
        return NotMatch;
    }

    /**
     * 常量定义
     */
    public static final int MatchedAndBlock = 0;
    public static final int NotMatch = 1;
}
