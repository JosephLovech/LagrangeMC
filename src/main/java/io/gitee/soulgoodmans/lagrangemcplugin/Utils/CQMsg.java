package io.gitee.soulgoodmans.lagrangemcplugin.Utils;

import java.util.ArrayList;

/**
 * CQ码
 */
public class CQMsg extends ArrayList {

    /**
     * 纯文本内容
     * @param text
     * @return
     */
    public CQMsg Text(String text){
        this.add(escape(text));
        return this;
    }

    /**
     * QQ表情
     * @param id QQ表情Id
     * @return
     */
    public CQMsg QQFace(Integer id){
        this.add(String.format("[CQ:face,id=%d]",id));
        return this;
    }

    /**
     * 图片
     * @param url 图片链接
     * @return
     */
    public CQMsg Image(String url){
        this.add(String.format("[CQ:image,file=%s]",escape(url)));
        return this;
    }

    /**
     * @某人
     * @param userId
     * @return
     */
    public CQMsg AtOne(Long userId){
        this.add(String.format("[CQ:at,qq=%d]",userId));
        return this;
    }

    /**
     * @全图成员
     * @return
     */
    public CQMsg AtAll(){
        this.add("[CQ:at,qq=all]");
        return this;
    }

    /**
     * 转换文本中的 CQ 码为可直接发送给 QQ 服务器的格式
     * @return
     */
    private String escape(String str){
        return str.replace("&", "&amp;")
                .replace(",", "&#44;")
                .replace("[", "&#91;")
                .replace("]", "&#93;");
    }

    @Override
    public String toString() {
        return String.join("",this);
    }
}
