package io.gitee.busilaoni.lagrangemcplugin.Handler;

import com.alibaba.fastjson2.JSONObject;
import io.gitee.busilaoni.lagrangemcplugin.Data.ApiData;
import io.gitee.busilaoni.lagrangemcplugin.Enums.Api;
import io.gitee.busilaoni.lagrangemcplugin.Result.ApiResult;
import org.java_websocket.WebSocket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Api消息处理
 */
public class ApiHandler {

    /**
     * 原子类Long作为echo
     */
    private final AtomicLong apiEcho = new AtomicLong();

    /**
     * 线程安全的HashMap 原子类Long作为Key, ApiSender作为Value
     */
    private static final Map<Long, ApiSender> apiCallbackMap = new ConcurrentHashMap<>();

    /**
     * 发送Api消息
     * param api Api枚举类
     * param map 内容
     * return
     */
    public JSONObject sendApiJson(Api api, Map map, WebSocket socket){

        try {
            //构建apiResult对象
            ApiResult result = getApiResult(api.getAction(),map);

            //获取echo值并作为key apiSender作为value存入到hashMap中
            Long echo = result.getEcho();

            ApiSender apiSender = new ApiSender(socket);
            apiCallbackMap.put(echo,apiSender);

            //发送api信息
            return apiSender.onSendMessage(getApiResult(api.getAction(),map));
        } catch (Exception e) {
            e.printStackTrace();
            //超时或者IO异常时返回错误信息
            return JSONObject.from(new ApiData<>("error",-1));
        }
    }

    /**
     * 收到 以前调用的API 的响应
     * param message 内容
     */
    public static void onReceiveApiMessage(JSONObject jsonObject) {

        //获取echo信息
        Long echo = jsonObject.getLong("echo");

        //从hashMap获取对应的ApiSender对象 并接收响应信息
        ApiSender sender = apiCallbackMap.get(echo-1);

        //判断hashMap中是否有对应的ApiSender对象，接收信息并移除该值
        if (sender != null){
            sender.onReceiveJson(jsonObject);
            apiCallbackMap.remove(echo);
        }
    }


    /**
     * 封装信息
     * param action
     * param params
     * return
     */
    private  ApiResult getApiResult(String action, Map params){
        ApiResult result = new ApiResult();
        //封装result
        result.setAction(action);
        result.setParams(params);
        result.setEcho(apiEcho.getAndIncrement());
        return result;
    }
}
