package io.gitee.busilaoni.lagrangemcplugin.Data.DataEntity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * 获取语音、图片的消息数据
 */
@Data
public class FileData {

    /**
     * 转换后的语音文件路径，如 /home/somebody/cqhttp/data/record/0B38145AA44505000B38145AA4450500.mp3
     * 收到的图片文件名（消息段的 file 参数），如 6B4DE3DFD1BD271E3297859D41C530F5.jpg
     */
    @JSONField(name = "file")
    private String file;
}
