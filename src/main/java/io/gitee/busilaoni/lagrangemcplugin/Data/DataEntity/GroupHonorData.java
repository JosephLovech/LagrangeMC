package io.gitee.busilaoni.lagrangemcplugin.Data.DataEntity;

import com.alibaba.fastjson2.annotation.JSONField;
import io.gitee.busilaoni.lagrangemcplugin.Entity.Current;
import io.gitee.busilaoni.lagrangemcplugin.Entity.CurrentTalkative;
import lombok.Data;

import java.util.List;

/**
 * 群荣誉的消息数据
 */
@Data
public class GroupHonorData {

    /**
     * 群号
     */
    @JSONField(name = "group_id")
    private Long groupId;

    /**
     * 当前龙王，仅 type为talkative或 all时有数据
     */
    @JSONField(name = "current_talkative")
    private CurrentTalkative currentTalkative;

    /**
     * 历史龙王，仅type为talkative或all时有数据
     */
    @JSONField(name = "talkative_list")
    private List<Current> talkativeList;

    /**
     * 群聊之火，仅type为performer或all时有数据
     */
    @JSONField(name = "performer_list")
    private List<Current> performerList;

    /**
     * 	群聊炽焰，仅type为performer或all时有数据
     */
    @JSONField(name = "legend_list")
    private List<Current> legendList;

    /**
     * 	冒尖小春笋，仅type为performer或all时有数据
     */
    @JSONField(name = "strong_newbie_list")
    private List<Current> strongNewbieList;

    /**
     * 	快乐之源，仅type为performer或all时有数据
     */
    @JSONField(name = "emotion_list")
    private List<Current> emotionList;
}
