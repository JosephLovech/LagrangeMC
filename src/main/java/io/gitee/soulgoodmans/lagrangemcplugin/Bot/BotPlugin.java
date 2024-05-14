package io.gitee.soulgoodmans.lagrangemcplugin.Bot;


import io.gitee.soulgoodmans.lagrangemcplugin.Event.Message.GroupMessageEvent;
import io.gitee.soulgoodmans.lagrangemcplugin.Event.Message.PrivateMessageEvent;

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
     * 事件内容
     * @param event
     * @return
     * 消息是否处理完毕,
     * `MatchedAndBlock`表示处理完毕不继续下一个插件处理,
     * `NotMatch`表示未处理并继续下一个插件处理
     */
    public int onPrivateMessage( PrivateMessageEvent event) {
        return NotMatch;
    }


    /**
     * 收到群消息时调用此方法
     *
     * 事件内容
     * @param event
     * @return
     * 消息是否处理完毕,
     * `MatchedAndBlock`表示处理完毕不继续下一个插件处理,
     * `NotMatch`表示未处理并继续下一个插件处理
     */
    public int onGroupMessage( GroupMessageEvent event) {
        return NotMatch;
    }


    // 常量定义
    public static final int MatchedAndBlock = 0;
    public static final int NotMatch = 1;
}
