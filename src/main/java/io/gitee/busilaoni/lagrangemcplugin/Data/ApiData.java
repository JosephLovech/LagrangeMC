package io.gitee.busilaoni.lagrangemcplugin.Data;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * ApiData 类用于封装API接口的返回数据，包含状态码、状态信息和具体数据。
 */
public class ApiData<T> {

    /**
     * 状态
     */
    @JSONField(name = "status")
    private String status;

    /**
     * 状态码
     */
    @JSONField(name = "retcode")
    private Integer retcode;

    /**
     * 数据
     */
    @JSONField(name = "data")
    private T data;
}
