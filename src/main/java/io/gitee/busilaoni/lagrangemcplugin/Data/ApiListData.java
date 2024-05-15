package io.gitee.busilaoni.lagrangemcplugin.Data;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * ApiListData类是API响应的数据模型
 */
@Data
public class ApiListData<T> {
    /**
     * API响应的状态
     */
    @JSONField(name = "status")
    private String status;

    /**
     * API响应的返回码
     */
    @JSONField(name = "retcode")
    private int retcode;

    /**
     * API返回的数据列表
     */
    @JSONField(name = "data")
    private List<T> data;
}