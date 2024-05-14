package io.github.JosephLovech.lagrangemcplugin.Utils;

import java.util.ArrayList;

/**
 * CQ码
 */
public class CQMsg extends ArrayList {

    /**
     * 纯文本内容
     * param text
     * return
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
     * @param file 图片文件名
     * @return
     */
    public CQMsg Image(String file){
        this.add(String.format("[CQ:image,file=%s]",escape(file)));
        return this;
    }

    /**
     * 图片
     * @param file 图片文件名
     * @param type 图片类型，flash 表示闪照，无此参数表示普通图片
     * @param cache 只在通过网络 URL 发送时有效，表示是否使用已缓存的文件，默认 1
     * @param proxy 只在通过网络 URL 发送时有效，表示是否通过代理下载文件（需通过环境变量或配置文件配置代理），默认 1
     * @param timeout 只在通过网络 URL 发送时有效，单位秒，表示下载网络文件的超时时间，默认不超时
     * @return
     */
    public CQMsg Image(String file, String type, Integer cache, Integer proxy, Integer timeout){
        this.add(String.format("[CQ:image,file=%s,type=%s,cache=%d,proxy=%d,timeout=%d]",escape(file),type,cache,proxy,timeout));
        return this;
    }

    /**
     * 语音
     * @param file 语音文件名
     * @return
     */
    public CQMsg Record(String file){
        this.add(String.format("[CQ:record,file=%s]",escape(file)));
        return this;
    }

    /**
     * 语音
     * @param file 语音文件名
     * @param magic 发送时可选，默认 0，设置为 1 表示变声
     * @param cache 只在通过网络 URL 发送时有效，表示是否使用已缓存的文件，默认 1
     * @param proxy 只在通过网络 URL 发送时有效，表示是否通过代理下载文件（需通过环境变量或配置文件配置代理），默认 1
     * @param timeout 只在通过网络 URL 发送时有效，单位秒，表示下载网络文件的超时时间 ，默认不超时
     * @return
     */
    public CQMsg Record(String file, Integer magic, Integer cache, Integer proxy, Integer timeout){
        this.add(String.format("[CQ:record,file=%s,magic=%d,cache=%d,proxy=%d,timeout=%d]",escape(file),magic,cache,proxy,timeout));
        return this;
    }

    /**
     * .@某人
     *
     * QQ号
     * param userId
     * return
     */
    public CQMsg AtOne(Long userId){
        this.add(String.format("[CQ:at,qq=%d]",userId));
        return this;
    }

    /**
     * .@全体成员
     * return
     */
    public CQMsg AtAll(){
        this.add("[CQ:at,qq=all]");
        return this;
    }

    /**
     * 转换文本中的 CQ 码为可直接发送给 QQ 服务器的格式
     * return
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
