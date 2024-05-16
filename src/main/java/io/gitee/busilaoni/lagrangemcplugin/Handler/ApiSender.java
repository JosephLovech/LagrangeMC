package io.gitee.busilaoni.lagrangemcplugin.Handler;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import io.gitee.busilaoni.lagrangemcplugin.Result.ApiResult;
import io.gitee.busilaoni.lagrangemcplugin.SocketServer;

/**
 * Api发送器
 */
public class ApiSender extends Thread{

    /**
     * ServerSocket 在插件加载中设置对象
     */
    public  SocketServer server;

    /**
     * 存储 API 响应的 JSON 对象
     */
    private JSONObject responseJson;

    /**
     * 用于等待 API 响应的锁对象
     */
    private final Object lock = new Object();

    public ApiSender(SocketServer server) {
        this.server = server;
    }

    /**
     * 发送 API 请求，并等待响应
     *
     * param apiJson API 请求的 JSON 对象
     * return API 响应的 JSON 对象
     */
    public  JSONObject onSendMessage(ApiResult result) throws InterruptedException {
        // 加锁同步代码块
        synchronized (lock) {
            server.broadcast(JSON.toJSONString(result));
            lock.wait(15000L);
        }

        //第一次发送
        if (responseJson == null){
            return JSON.parseObject("{\"status\": \"error\",\"retcode\": 0,\"echo\": -1}");
        }
        return responseJson;
    }

    /**
     * 处理收到的 API 响应，将响应内容存储在 responseJson 中，然后唤醒等待线程
     *
     * @param jsonObject 收到的 API 响应的 JSON 对象
     */
    public void onReceiveJson(JSONObject jsonObject) {
        // 加锁同步代码块
        synchronized (lock) {
            this.responseJson = jsonObject;
            lock.notify();
        }
    }
}
