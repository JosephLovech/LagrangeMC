package io.gitee.busilaoni.lagrangemcplugin.Entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.ToString;

/**
 * 发送者信息
 */
@Data
@ToString
public class Sender {

    /**
     * 发送者QQ号
     */
    @JSONField(name = "user_id")
    private Integer userId;

    /**
     * 昵称
     */
    @JSONField(name = "nickname")
    private String nickname;

    /**
     * 性别 male、female、unknown
     */
    @JSONField(name = "sex")
    private String sex;

    /**
     * 年龄
     */
    @JSONField(name = "age")
    private Long age;

    /**
     * 群名片/备注
     */
    @JSONField(name = "card")
    private String card;

    /**
     * 地区
     */
    @JSONField(name = "area")
    private String area;

    /**
     * 成员等级
     */
    @JSONField(name = "level")
    private String level;

    /**
     * 角色，owner、admin、member
     */
    @JSONField(name = "role")
    private String role;

    /**
     * 专属头衔
     */
    @JSONField(name = "title")
    private String title;
}
