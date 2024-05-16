package io.gitee.busilaoni.lagrangemcplugin.Handler;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import io.gitee.busilaoni.lagrangemcplugin.Data.ApiData;
import io.gitee.busilaoni.lagrangemcplugin.Enums.Api;
import io.gitee.busilaoni.lagrangemcplugin.Result.ApiResult;
import io.gitee.busilaoni.lagrangemcplugin.SocketServer;

import java.io.IOException;
import java.util.Map;

/**
 * Api发送器
 */
public class ApiSender {

    /**
     * ServerSocket 在插件加载中设置对象
     */
    public static SocketServer server;

    /**
     * 存储 API 响应的 JSON 对象
     */
    private static JSONObject responseJson;

    /**
     * 用于等待 API 响应的锁对象
     */
    private static final Object lock = new Object();


    /**
     * 发送Api消息
     * param api Api枚举类
     * param map 内容
     * return
     */
    public static JSONObject sendApiJson(Api api, Map map){
        try {
            //发送api信息
            return sendMessage(getApiResult(api.getAction(),map));
        } catch (Exception e) {
            e.printStackTrace();
            //超时或者IO异常时返回错误信息
            return JSONObject.from(new ApiData<>("error",-1));
        }
    }

    /**
     * 发送 API 请求，并等待响应
     *
     * param apiJson API 请求的 JSON 对象
     * return API 响应的 JSON 对象
     */
    public static JSONObject sendMessage(ApiResult result) throws IOException, InterruptedException {
        // 加锁同步代码块
        synchronized (lock) {
            server.broadcast(JSON.toJSONString(result));
        }
        return responseJson;
    }

    /**
     * 处理收到的 API 响应，将响应内容存储在 responseJson 中，然后唤醒等待线程
     *
     * @param jsonObject 收到的 API 响应的 JSON 对象
     */
    public static void onReceiveJson(JSONObject jsonObject) {
        // 加锁同步代码块
        synchronized (lock) {
            responseJson = jsonObject;
        }
    }

    /**
     * 封装信息
     * param action
     * param params
     * return
     */
    private static ApiResult getApiResult(String action, Map params){
        ApiResult result = new ApiResult();
        //封装result
        result.setAction(action);
        result.setParams(params);
        return result;
    }
}
