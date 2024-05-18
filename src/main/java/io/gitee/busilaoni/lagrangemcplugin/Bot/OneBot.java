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
     * 全构造器
     */
    public OneBot(Long botId, ApiHandler apiHandler, WebSocket socket) {
        this.botId = botId;
        this.apiHandler = apiHandler;
        this.socket = socket;
    }

    public Long getBotId() {
        return botId;
    }

    public ApiHandler getApiHandler() {
        return apiHandler;
    }

    public void setApiHandler(ApiHandler apiHandler) {
        this.apiHandler = apiHandler;
    }

    public WebSocket getSocket() {
        return socket;
    }

    public void setSocket(WebSocket socket) {
        this.socket = socket;
    }
}
