package io.gitee.busilaoni.lagrangemcplugin;

import com.alibaba.fastjson2.JSONObject;
import io.gitee.busilaoni.lagrangemcplugin.Bot.BotContainer;
import io.gitee.busilaoni.lagrangemcplugin.Handler.ApiHandler;
import io.gitee.busilaoni.lagrangemcplugin.Handler.EventHandler;
import lombok.Data;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
public class SocketServer extends WebSocketServer {

    /**
     * 事件处理器
     */
    private EventHandler eventHandler;

    /**
     * 线程池
     */
    private ExecutorService executor;

    /**
     * 端口号
     *
     * @param port 开启的端口号
     */
    public SocketServer(Integer port) {
        super(new InetSocketAddress(port));

        //添加eventHandler和executor
        eventHandler = new EventHandler();
        executor = Executors.newFixedThreadPool(8);
    }

    /**
     * 开启连接
     *
     * @param conn websocket对象
     * @param handshake 连接信息
     */
    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {

        //获取机器人QQ号
        Long botId = Long.valueOf(handshake.getFieldValue("X-Self-ID"));
        System.out.println(String.format("[info]: 添加QQ: %d",botId));

        BotContainer.createBot(botId,conn);
    }

    /**
     *  关闭连接
     *
     * @param conn websocket对象
     * @param code 状态码
     * @param reason 断开原因
     * @param remote 关闭
     */
    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {

        System.out.println(String.format("[warning]: 机器人连接断开"));
    }

    /**
     * 接受客户端消息
     *
     * @param conn websocket对象
     * @param message 发送的信息
     */
    @Override
    public void onMessage(WebSocket conn, String message) {

        //转化为JsonObject类型
        JSONObject jsonObject = JSONObject.parse(message);

        //判断是否为api返回的数据
        if (jsonObject.containsKey("echo")){
            ApiHandler.onReceiveApiMessage(jsonObject);
            return;
        }

        //将事件处理任务提交到线程池中执行
        Long botId = jsonObject.getLong("self_id");
        executor.execute(()->{eventHandler.handler(BotContainer.getBot(botId), jsonObject);});
    }

    /**
     * 错误信息
     *
     * @param conn websocket对象
     * @param ex 错误类型
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
