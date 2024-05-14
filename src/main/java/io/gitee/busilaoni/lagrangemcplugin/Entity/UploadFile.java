package io.gitee.busilaoni.lagrangemcplugin.Entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 上传文件信息
 */
@Data
public class UploadFile {

    /**
     * 文件id
     */
    @JSONField(name = "id")
    private String id;

    /**
     * 文件名
     */
    @JSONField(name = "name")
    private String name;

    /**
     * 文件大小(字节数)
     */
    @JSONField(name = "size")
    private Long size;

    /**
     *
     */
    @JSONField(name = "busid")
    private Long busid;
}
