package io.gitee.busilaoni.lagrangemcplugin.Utils;

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
     * param id QQ表情Id
     * return
     */
    public CQMsg QQFace(Integer id){
        this.add(String.format("[CQ:face,id=%d]",id));
        return this;
    }

    /**
     * 图片
     * param file 图片文件名
     * return
     */
    public CQMsg Image(String file){
        this.add(String.format("[CQ:image,file=%s]",escape(file)));
        return this;
    }

    /**
     * 图片
     * param file 图片文件名
     * param type 图片类型，flash 表示闪照，无此参数表示普通图片
     * param cache 只在通过网络 URL 发送时有效，表示是否使用已缓存的文件，默认 1
     * param proxy 只在通过网络 URL 发送时有效，表示是否通过代理下载文件（需通过环境变量或配置文件配置代理），默认 1
     * param timeout 只在通过网络 URL 发送时有效，单位秒，表示下载网络文件的超时时间，默认不超时
     * return
     */
    public CQMsg Image(String file, String type, Integer cache, Integer proxy, Integer timeout){
        this.add(String.format("[CQ:image,file=%s,type=%s,cache=%d,proxy=%d,timeout=%d]",escape(file),type,cache,proxy,timeout));
        return this;
    }

    /**
     * 语音
     * param file 语音文件名
     * return
     */
    public CQMsg Record(String file){
        this.add(String.format("[CQ:record,file=%s]",escape(file)));
        return this;
    }

    /**
     * 语音
     * param file 语音文件名
     * param magic 发送时可选，默认 0，设置为 1 表示变声
     * param cache 只在通过网络 URL 发送时有效，表示是否使用已缓存的文件，默认 1
     * param proxy 只在通过网络 URL 发送时有效，表示是否通过代理下载文件（需通过环境变量或配置文件配置代理），默认 1
     * param timeout 只在通过网络 URL 发送时有效，单位秒，表示下载网络文件的超时时间 ，默认不超时
     * return
     */
    public CQMsg Record(String file, Integer magic, Integer cache, Integer proxy, Integer timeout){
        this.add(String.format("[CQ:record,file=%s,magic=%d,cache=%d,proxy=%d,timeout=%d]",escape(file),magic,cache,proxy,timeout));
        return this;
    }

    /**
     * 视频
     * param file 视频文件名
     * return
     */
    public CQMsg Video(String file){
        this.add(String.format("[CQ:video,file=%s]",escape(file)));
        return this;
    }

    /**
     * 视频
     * param file 视频文件名
     * param cache 只在通过网络 URL 发送时有效，表示是否使用已缓存的文件，默认 1
     * param proxy 只在通过网络 URL 发送时有效，表示是否通过代理下载文件（需通过环境变量或配置文件配置代理），默认 1
     * param timeout 只在通过网络 URL 发送时有效，单位秒，表示下载网络文件的超时时间 ，默认不超时
     * return
     */
    public CQMsg Video(String file, Integer cache, Integer proxy, Integer timeout){
        this.add(String.format("[CQ:video,file=%s,cache=%d,proxy=%d,timeout=%d]",escape(file),cache,proxy,timeout));
        return this;
    }

    /**
     * .@某人
     * param userId QQ号
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
     * 猜拳魔法表情
     * return
     */
    public CQMsg Punch(){
        this.add("[CQ:rps]");
        return this;
    }

    /**
     * 掷骰子魔法表情
     * return
     */
    public CQMsg Sieve(){
        this.add("[CQ:dice]");
        return this;
    }

    /**
     * 窗口抖动（戳一戳）
     * return
     */
    public CQMsg Shake(){
        this.add("[CQ:shake]");
        return this;
    }

    /**
     * 戳一戳
     * return
     */
    public CQMsg Poke(Integer type, Integer id){
        this.add(String.format("[CQ:poke,type=%d,id=%d]", type, id));
        return this;
    }

    /**
     * 匿名消息
     * param ignore 可选0、1，表示无法匿名时是否继续发送
     * return
     */
    public CQMsg Anonymous(Integer ignore){
        this.add(String.format("[CQ:anonymous,ignore=%d]", ignore));
        return this;
    }

    /**
     * 链接分享
     * param url 链接
     * param title 标题
     * return
     */
    public CQMsg Share(String url, String title){
        this.add(String.format("[CQ:share,url=%s,title=%s]", escape(url), escape(title)));
        return this;
    }

    /**
     * 链接分享
     * param url 链接
     * param title 标题
     * param content 发送时可选，内容描述
     * param image 发送时可选，图片 URL
     * return
     */
    public CQMsg Share(String url, String title, String content, String image){
        this.add(String.format("[CQ:share,url=%s,title=%s,content=%s,image=%s]", escape(url), escape(title), escape(content), escape(image)));
        return this;
    }

    /**
     * 推荐好友或群
     * param type 推荐好友 qq 推荐群 group
     * param id 被推荐的QQ号或群号
     * return
     */
    public CQMsg Contact(String type, Long id){
        this.add(String.format("[CQ:contact,type=%s,id=%d]", escape(type), id));
        return this;
    }

    /**
     * 位置
     * param lat 纬度
     * param lon 经度
     * return
     */
    public CQMsg Location(Double lat, Double lon){
        this.add(String.format("[CQ:location,lat=%f,lon=%f]", lat, lon));
        return this;
    }

    /**
     * 位置
     * param lat 纬度
     * param lon 经度
     * param title 发送时可选，标题
     * param content 发送时可选，内容描述
     * return
     */
    public CQMsg Location(Double lat, Double lon, String title, String content){
        this.add(String.format("[CQ:location,lat=%f,lon=%f,title=%s,content=%s]", lat, lon, escape(title), escape(content)));
        return this;
    }

    /**
     * 音乐分享
     * param type qq、163、xm 分别表示使用QQ音乐、网易云音乐、虾米音乐
     * param id 歌曲 ID
     * return
     */
    public CQMsg Music(String type, Long id){
        this.add(String.format("[CQ:music,type=%s,id=%d]", type, id));
        return this;
    }

    /**
     * 音乐自定义分享
     * param type custom 表示音乐自定义分享
     * param url 点击后跳转目标 URL
     * param audio 音乐 URL
     * param title 标题
     * param content 发送时可选，内容描述
     * param image 发送时可选，图片 URL
     * return
     */
    public CQMsg Music(String type, String url, String audio, String title, String content, String image){
        this.add(String.format("[CQ:music,type=%s,url=%s,title=%s,content=%s,image=%s]", escape(title), escape(url), escape(audio),  escape(title), escape(content), escape(image)));
        return this;
    }

    /**
     * 回复
     * param id 回复时引用的消息 ID
     * return
     */
    public CQMsg Reply(Long id){
        this.add(String.format("[CQ:reply,id=%d]", id));
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
