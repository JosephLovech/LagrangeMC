package io.gitee.busilaoni.lagrangemcplugin.Data.DataEntity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * api请求陌生人的消息数据
 */
@Data
public class StrangerData {

    /**
     * QQ号
     */
    @JSONField(name = "user_id")
    private Long userId;

    /**
     * 昵称
     */
    @JSONField(name = "nickname")
    private Long nickname;

    /**
     * 性别 性别，male或female或unknown
     */
    @JSONField(name = "sex")
    private String sex;

    /**
     * 年龄
     */
    @JSONField(name = "age")
    private Integer age;
}
