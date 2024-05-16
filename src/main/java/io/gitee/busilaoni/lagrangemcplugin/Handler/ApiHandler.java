package io.gitee.busilaoni.lagrangemcplugin.Handler;

import com.alibaba.fastjson2.JSONObject;

/**
 * Api消息处理
 */
public class ApiHandler {

    /**
     * 收到 以前调用的API 的响应
     * param message 内容
     */
    public static void onReceiveApiMessage(JSONObject jsonObject) {
        ApiSender.onReceiveJson(jsonObject);
    }
}
