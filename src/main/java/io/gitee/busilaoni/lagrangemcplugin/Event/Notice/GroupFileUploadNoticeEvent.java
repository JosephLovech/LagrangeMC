package io.gitee.busilaoni.lagrangemcplugin.Event.Notice;

import com.alibaba.fastjson2.annotation.JSONField;
import io.gitee.busilaoni.lagrangemcplugin.Entity.UploadFile;
import lombok.Data;

/**
 * 群文件上传事件
 */
@Data
public class GroupFileUploadNoticeEvent extends NoticeEvent{

    /**
     * 群号
     */
    @JSONField(name = "group_id")
    private Long groupId;

    /**
     * 发送者QQ号
     */
    @JSONField(name = "user_id")
    private Long userId;

    /**
     * 文件信息
     */
    @JSONField(name = "file")
    private UploadFile file;
}
