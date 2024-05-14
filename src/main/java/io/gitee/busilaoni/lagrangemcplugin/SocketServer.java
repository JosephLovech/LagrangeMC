package io.gitee.busilaoni.lagrangemcplugin;

import com.alibaba.fastjson2.JSONObject;
import io.gitee.busilaoni.lagrangemcplugin.Bot.BotPlugin;
import io.gitee.busilaoni.lagrangemcplugin.Event.Message.GroupMessageEvent;
import io.gitee.busilaoni.lagrangemcplugin.Event.Message.PrivateMessageEvent;
import lombok.Data;
import org.bukkit.Bukkit;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.function.Function;

@Data
public class SocketServer extends WebSocketServer {

    /**
     * 端口号
     * param port
     */
    public SocketServer(Integer port) {
        super(new InetSocketAddress(port));
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

        //获取postType类型
        String postType = jsonObject.getString("post_type");

        //没有postType参数时为响应数据
        if (postType == null){
            return;
        }

        // 根据事件类型分发到不同的处理方法中
        switch (postType) {
            // 如果是消息事件，则调用 handleMessage 方法处理
            case "message":
                handleMessage(jsonObject);
            break;

            // 如果是自己发送的消息事件，则调用 handleMySelfMessage 方法处理
            case "message_sent":

            break;

            // 如果是通知事件，则调用 handleNotice 方法处理
            case "notice":

            break;

            // 如果是请求事件，则调用 handleRequest 方法处理
            case "request":

            break;

            // 如果是元事件，则调用 handleMeta 方法处理
            case "meta_event":

            break;

            // 未知事件类型
            default:
                Bukkit.getLogger().warning(String.format("Unknown post type: %s",message));
            break;
        }
    }

    /**
     * 处理接受到的消息
     * param jsonObject
     */
    private void handleMessage(JSONObject jsonObject){

        //获取messageType类型
        String messageType = jsonObject.getString("message_type");

        switch (messageType){

            /**
             * 私聊消息
             */
            case "private":
                //消息转换对应类型
                PrivateMessageEvent privateMessageEvent = jsonObject.toJavaObject(PrivateMessageEvent.class);

                //转发执行
                handlePluginMessages(botPlugin -> botPlugin.onPrivateMessage(privateMessageEvent));
            break;

            /**
             * 群聊消息
             */
            case "group":

                //消息转换对应类型
                GroupMessageEvent groupMessageEvent = jsonObject.toJavaObject(GroupMessageEvent.class);

                //转发执行
                handlePluginMessages(botPlugin -> botPlugin.onGroupMessage(groupMessageEvent));
            break;

            /**
             * 其他消息
             */
            default:
                Bukkit.getLogger().warning(String.format("Unknown message type: %s",jsonObject.toString()));
            break;
        }
    }

    /**
     * 处理插件消息。
     * 处理方法，接受一个 BotPlugin 参数，并返回一个整数结果
     * param action
     */
    private void handlePluginMessages(Function<BotPlugin, Integer> action) {

        //遍历插件列表
        for (Class<? extends BotPlugin> pluginClass : BotPlugin.pluginList) {

            //转换为实例对象
            BotPlugin plugin = getPlugin(pluginClass);

            //执行插件
            if (plugin != null && action.apply(plugin) == BotPlugin.MatchedAndBlock) {
                return;
            }
        }
    }

    /**
     * 获取指定类型的插件实例。
     * param clazz 插件类型
     * param <T> 插件类型参数
     * return 插件实例，如果不存在，则返回 null
     */
    private <T> T getPlugin(Class<T> clazz) {
        try {
            //反射获取实例对象
            return clazz.getConstructor().newInstance();
        } catch (Exception e) {
            Bukkit.getLogger().info(String.format("获取插件：%s出错",clazz.toString()));
            return null;
        }
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
