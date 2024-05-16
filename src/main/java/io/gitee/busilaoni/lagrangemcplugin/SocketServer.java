package io.gitee.busilaoni.lagrangemcplugin;

import com.alibaba.fastjson2.JSONObject;
import io.gitee.busilaoni.lagrangemcplugin.Handler.ApiHandler;
import io.gitee.busilaoni.lagrangemcplugin.Handler.EventHandler;
import lombok.Data;
import org.bukkit.Bukkit;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

@Data
public class SocketServer extends WebSocketServer {

    /**
     * 事件处理器
     */
    private EventHandler eventHandler;

    /**
     * 端口号
     * param port
     */
    public SocketServer(Integer port) {
        super(new InetSocketAddress(port));
        eventHandler = new EventHandler();
    }

    /**
     * 开启连接
     * param conn
     * param handshake
     */
    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {

    }

    /**
     *  关闭连接
     * param conn
     * param code
     * param reason
     * param remote
     */
    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {

    }

    /**
     * 接受客户端消息
     * param conn
     * param message
     */
    @Override
    public void onMessage(WebSocket conn, String message) {

        //转化为JsonObject类型
        JSONObject jsonObject = JSONObject.parse(message);

        //判断是否为api返回的数据
        if (jsonObject.containsKey("retcode")){
            ApiHandler.onReceiveApiMessage(jsonObject);
            return;
        }

        //处理事件
        eventHandler.handler(jsonObject);
    }

    /**
     * 错误信息
     * param conn
     * param ex
     */
    @Override
    public void onError(WebSocket conn, Exception ex) {

    }

    @Override
    public void onStart() {
        setConnectionLostTimeout(0);
        setConnectionLostTimeout(100);
    }
}
