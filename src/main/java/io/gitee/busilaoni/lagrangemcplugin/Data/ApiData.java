package io.gitee.busilaoni.lagrangemcplugin.Data;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ApiData 类用于封装API接口的返回数据，包含状态码、状态信息和具体数据。
 */
@Data
@NoArgsConstructor
public class ApiData<T> {

    public ApiData(String status, Integer retcode) {
        this.status = status;
        this.retcode = retcode;
    }

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

    /**
     * echo
     */
    @JSONField(name = "echo")
    private Long echo;
}
