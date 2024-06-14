package io.gitee.busilaoni.lagrangemcplugin.Bot;

import io.gitee.busilaoni.lagrangemcplugin.Handler.ApiHandler;
import org.java_websocket.WebSocket;

public class OneBot{

    /**
     * 机器人的QQ号
     */
    private Long botId;

    /**
     * apiHandler
     */
    private ApiHandler apiHandler;

    /**
     * socket
     */
    private WebSocket socket;

    /**
     * 构建机器人对象
     *
     * @param botId 机器人QQ号
     * @param apiHandler apiHandler对象
     * @param socket webSocket对象
     */
    public OneBot(Long botId, ApiHandler apiHandler, WebSocket socket) {
        this.botId = botId;
        this.apiHandler = apiHandler;
        this.socket = socket;
    }

    /**
     * 获取机器人QQ号
     *
     * @return 返回机器人QQ号
     */
    public Long getBotId() {
        return botId;
    }

    /**
     * 获取ApiHandler对象
     *
     * @return 返回ApiHandler对象
     */
    public ApiHandler getApiHandler() {
        return apiHandler;
    }

    /**
     * 设置apiHandler对象
     *
     * @param apiHandler apiHandler对象
     */
    public void setApiHandler(ApiHandler apiHandler) {
        this.apiHandler = apiHandler;
    }

    /**
     * 获取webSocket对象
     *
     * @return 返回webSocket对象
     */
    public WebSocket getSocket() {
        return socket;
    }

    /**
     * 设置webSocket对象
     *
     * @param socket webSocket对象
     */
    public void setSocket(WebSocket socket) {
        this.socket = socket;
    }
}
