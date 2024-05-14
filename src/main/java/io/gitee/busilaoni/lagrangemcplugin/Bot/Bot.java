package io.gitee.busilaoni.lagrangemcplugin.Bot;

import com.alibaba.fastjson2.JSON;
import io.gitee.busilaoni.lagrangemcplugin.Enums.Api;
import io.gitee.busilaoni.lagrangemcplugin.Result.ApiResult;
import org.java_websocket.server.WebSocketServer;

import java.util.HashMap;
import java.util.Map;

/**
 * 机器人发送api
 */
public class Bot {

    /**
     * websocket广播
     */
    public static WebSocketServer socketServer;

    /**
     * 发送私聊消息
     *
     * param userId QQ号
     * param message 信息
     * param escape 消息内容是否作为纯文本发送
     */
    public static void sendPrivateMessage(Long userId,String message, boolean escape){
        Map map = new HashMap();
        map.put("user_id",userId);
        map.put("message",message);
        map.put("auto_escape",escape);
        socketServer.broadcast(JSON.toJSONString(getApiResult(Api.SEND_PRIVATE_MSG,map)));
    }

    /**
     * 发送群消息
     *
     * param groupId 群号
     * param message 信息
     * param escape 消息内容是否作为纯文本发送
     */
    public static void sendGroupMessage(Long groupId,String message, boolean escape){
        Map map = new HashMap();
        map.put("group_id",groupId);
        map.put("message",message);
        map.put("auto_escape",escape);
        socketServer.broadcast(JSON.toJSONString(getApiResult(Api.SEND_GROUP_MSG,map)));
    }

    /**
     * 发送消息
     * param messageType 消息类型，支持 private、group，分别对应私聊、群组，如不传入，则根据传入的 *_id 参数判断
     * param userId 对方 QQ 号（消息类型为 private 时需要）
     * param groupId 群号（消息类型为 group 时需要）
     * param message 要发送的内容
     * param escape 消息内容是否作为纯文本发送（即不解析 CQ 码），只在 message 字段是字符串时有效
     */
    public static void sendMessage(String messageType, Long userId, Long groupId, String message, boolean escape){
        Map map = new HashMap();
        map.put("message_type", messageType);
        map.put("user_id",userId);
        map.put("group_id",groupId);
        map.put("message",message);
        map.put("auto_escape",escape);
        socketServer.broadcast(JSON.toJSONString(getApiResult(Api.SEND_GROUP_MSG,map)));
    }

    /**
     * 撤回消息
     * param messageId 消息id
     */
    public static void deleteMessage(Long messageId){
        Map map = new HashMap();
        map.put("message_id", messageId);
        socketServer.broadcast(JSON.toJSONString(getApiResult(Api.DELETE_MSG,map)));
    }

    /**
     * 获取消息
     * param messageId 消息id
     */
    public static void getMessage(Long messageId){
        Map map = new HashMap();
        map.put("message_id", messageId);
        socketServer.broadcast(JSON.toJSONString(getApiResult(Api.GET_MSG,map)));
    }

    /**
     * 获取合并转发消息
     * param messageId 消息id
     */
    public static void getForwardMessage(Long messageId){
        Map map = new HashMap();
        map.put("message_id", messageId);
        socketServer.broadcast(JSON.toJSONString(getApiResult(Api.GET_FORWARD_MSG,map)));
    }

    /**
     * 封装信息
     * param api
     * param params
     * return
     */
    private static ApiResult getApiResult(Api api, Map params){
        ApiResult result = new ApiResult();
        //封装result
        result.setAction(api.getAction());
        result.setParams(params);
        return result;
    }
}
