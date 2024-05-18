package io.gitee.busilaoni.lagrangemcplugin.Bot;

import io.gitee.busilaoni.lagrangemcplugin.Handler.ApiHandler;
import org.java_websocket.WebSocket;

import java.util.HashMap;
import java.util.Map;

public class BotContainer {

    /**
     * bot容器
     */
    public static  Map<Long,Bot> bots = new HashMap<>();

    /**
     * 根据BotId获取机器人
     * param botId
     * return
     */
    public static Bot getBot(long botId) {

        //如果bot容器没有机器人实例时
        if (bots.isEmpty()) {
            return null;
        }
        return bots.get(botId);
    }

    /**
     *  创建机器人实例
     */
    public static Bot createBot(Long botId, WebSocket socket){

        //创建新机器人
        Bot bot = new Bot(botId, new ApiHandler(), socket);

        //添加进容器中 若断开连接后再次连接，map将会替换该键值对
        bots.put(botId,bot);

        return bot;
    }
}
