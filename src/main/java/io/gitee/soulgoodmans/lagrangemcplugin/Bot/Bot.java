package io.gitee.soulgoodmans.lagrangemcplugin.Bot;

import com.alibaba.fastjson2.JSON;
import io.gitee.soulgoodmans.lagrangemcplugin.Enums.Api;
import io.gitee.soulgoodmans.lagrangemcplugin.Result.ApiResult;
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
     * @param userId 好友号
     * @param message 信息
     * @param escape 消息内容是否作为纯文本发送
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
     * @param groupId 群号
     * @param message 信息
     * @param escape 消息内容是否作为纯文本发送
     */
    public static void sendGroupMessage(Long groupId,String message, boolean escape){
        Map map = new HashMap();
        map.put("group_id",groupId);
        map.put("message",message);
        map.put("auto_escape",escape);
        socketServer.broadcast(JSON.toJSONString(getApiResult(Api.SEND_GROUP_MSG,map)));
    }

    /**
     * 封装信息
     * @param api
     * @param params
     * @return
     */
    private static ApiResult getApiResult(Api api, Map params){
        ApiResult result = new ApiResult();
        //封装result
        result.setAction(api.getAction());
        result.setParams(params);
        return result;
    }
}
