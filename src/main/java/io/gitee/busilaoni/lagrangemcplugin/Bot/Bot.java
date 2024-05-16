package io.gitee.busilaoni.lagrangemcplugin.Bot;

import com.alibaba.fastjson2.TypeReference;
import io.gitee.busilaoni.lagrangemcplugin.Data.ApiData;
import io.gitee.busilaoni.lagrangemcplugin.Data.DataEntity.*;
import io.gitee.busilaoni.lagrangemcplugin.Entity.Anonymous;
import io.gitee.busilaoni.lagrangemcplugin.Enums.Api;
import io.gitee.busilaoni.lagrangemcplugin.Handler.ApiHandler;
import io.gitee.busilaoni.lagrangemcplugin.Handler.ApiSender;
import io.gitee.busilaoni.lagrangemcplugin.Result.ApiResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 机器人发送api
 */
public class Bot {

    /**
     * 发送私聊消息
     *
     * param userId QQ号
     * param message 信息
     * param escape 消息内容是否作为纯文本发送
     */
    public static ApiData<MessageRespData> sendPrivateMessage(Long userId, String message, boolean escape){
        Map map = new HashMap();
        map.put("user_id",userId);
        map.put("message",message);
        map.put("auto_escape",escape);
        return ApiHandler.sendApiJson(Api.SEND_PRIVATE_MSG,map).to(new TypeReference<ApiData<MessageRespData>>() {
        });
    }

    /**
     * 发送群消息
     *
     * param groupId 群号
     * param message 信息
     * param escape 消息内容是否作为纯文本发送
     */
    public static ApiData<MessageRespData> sendGroupMessage(Long groupId,String message, boolean escape){
        Map map = new HashMap();
        map.put("group_id",groupId);
        map.put("message",message);
        map.put("auto_escape",escape);
        return ApiHandler.sendApiJson(Api.SEND_GROUP_MSG,map).to(new TypeReference<ApiData<MessageRespData>>() {
        });
    }

    /**
     * 发送消息
     * param messageType 消息类型，支持 private、group，分别对应私聊、群组，如不传入，则根据传入的 *_id 参数判断
     * param userId 对方 QQ 号（消息类型为 private 时需要）
     * param groupId 群号（消息类型为 group 时需要）
     * param message 要发送的内容
     * param escape 消息内容是否作为纯文本发送（即不解析 CQ 码），只在 message 字段是字符串时有效
     */
    public static ApiData<MessageRespData> sendMessage(String messageType, Long userId, Long groupId, String message, boolean escape){
        Map map = new HashMap();
        map.put("message_type", messageType);
        map.put("user_id",userId);
        map.put("group_id",groupId);
        map.put("message",message);
        map.put("auto_escape",escape);
        return ApiHandler.sendApiJson(Api.SEND_MSG,map).to(new TypeReference<ApiData<MessageRespData>>() {
        });
    }

    /**
     * 撤回消息
     * param messageId 消息id
     */
    public static void deleteMessage(Long messageId){
        Map map = new HashMap();
        map.put("message_id", messageId);
        ApiHandler.sendApiJson(Api.DELETE_MSG,map);
    }

    /**
     * 获取消息
     * param messageId 消息id
     */
    public static ApiData<MessageData> getMessage(Long messageId){
        Map map = new HashMap();
        map.put("message_id", messageId);
        return ApiHandler.sendApiJson(Api.GET_MSG,map).to(new TypeReference<ApiData<MessageData>>() {
        });
    }

    /**
     * 获取合并转发消息
     * param messageId 消息id
     */
    public static String getForwardMessage(String id){
        Map map = new HashMap();
        map.put("id", id);
        return ApiHandler.sendApiJson(Api.GET_FORWARD_MSG,map).toJavaObject(String.class);
    }

    /**
     * 发送好友赞
     * param userId 对方QQ号
     * param times 赞的次数，每个好友每天最多10次 默认值1
     */
    public static void sendLike(Long userId, Integer times){
        Map map = new HashMap();
        map.put("user_id", userId);
        map.put("times", times);
        ApiHandler.sendApiJson(Api.SEND_LIKE,map);
    }

    /**
     * 群组踢人
     * param groupId
     * param userId
     * param rejectAddRequest
     */
    public static void setGroupKick(Long groupId ,Long userId, boolean rejectAddRequest){
        Map map = new HashMap();
        map.put("group_id", groupId);
        map.put("user_id", userId);
        map.put("reject_add_request", rejectAddRequest);
        ApiHandler.sendApiJson(Api.SET_GROUP_KICK,map);
    }

    /**
     * 群组单人禁言
     * param groupId 群号
     * param userId 要禁言的QQ号
     * param duration 禁言时长，单位秒，0表示取消禁言
     */
    public static void setGroupBan(Long groupId ,Long userId, Long duration){
        Map map = new HashMap();
        map.put("group_id", groupId);
        map.put("user_id", userId);
        map.put("duration", duration);
        ApiHandler.sendApiJson(Api.SET_GROUP_BAN,map);
    }

    /**
     * 群组匿名用户禁言
     * param groupId 群号
     * param anonymous 可选，要禁言的匿名用户对象（群消息上报的 anonymous 字段）
     * param anonymousFlag 可选，要禁言的匿名用户的 flag（需从群消息上报的数据中获得）
     * param duration 禁言时长，单位秒，无法取消匿名用户禁言
     */
    public static void setGroupAnonymousBan(Long groupId , Anonymous anonymous, String anonymousFlag, Long duration){
        Map map = new HashMap();
        map.put("group_id", groupId);
        map.put("anonymous", anonymous);
        map.put("anonymous_flag", anonymousFlag);
        map.put("duration", duration);
        ApiHandler.sendApiJson(Api.SET_GROUP_ANONYMOUS_BAN,map);
    }

    /**
     * 群组全员禁言
     * param groupId 群号
     * param enable 是否禁言
     */
    public static void setGroupWholeBan(Long groupId, boolean enable){
        Map map = new HashMap();
        map.put("group_id", groupId);
        map.put("enable", enable);
        ApiHandler.sendApiJson(Api.SET_GROUP_WHOLE_BAN,map);
    }

    /**
     * 群组设置管理员
     * param groupId 群号
     * param userId 要设置管理员的 QQ 号
     * param enable true 为设置，false 为取消
     */
    public static void setGroupAdmin(Long groupId, Long userId, boolean enable){
        Map map = new HashMap();
        map.put("group_id", groupId);
        map.put("user_id", userId);
        map.put("enable", enable);
        ApiHandler.sendApiJson(Api.SET_GROUP_ADMIN,map);
    }

    /**
     * 群组匿名
     * param groupId 群号
     * param enable 是否允许匿名聊天
     */
    public static void setGroupAnonymous(Long groupId, boolean enable){
        Map map = new HashMap();
        map.put("group_id", groupId);
        map.put("enable", enable);
        ApiHandler.sendApiJson(Api.SET_GROUP_ANONYMOUS,map);
    }

    /**
     * 设置群成员备注
     * param groupId 群号
     * param userId 要设置的QQ号
     * param card 群名片内容，不填或空字符串表示删除群成员备注
     */
    public static void setGroupCard(Long groupId, Long userId, String card){
        Map map = new HashMap();
        map.put("group_id", groupId);
        map.put("user_id", userId);
        map.put("card", card);
        ApiHandler.sendApiJson(Api.SET_GROUP_CARD,map);
    }

    /**
     * 设置群名
     * param groupId 群号
     * param groupName 新群名
     */
    public static void setGroupName(Long groupId, String groupName){
        Map map = new HashMap();
        map.put("group_id", groupId);
        map.put("group_name", groupName);
        ApiHandler.sendApiJson(Api.SET_GROUP_NAME,map);
    }

    /**
     * 退出群组
     * param groupId 群号
     * param isDismiss 是否解散，如果登录号是群主，则仅在此项为true时能够解散
     */
    public static void setGroupLeave(Long groupId, boolean isDismiss){
        Map map = new HashMap();
        map.put("group_id", groupId);
        map.put("is_dismiss", isDismiss);
        ApiHandler.sendApiJson(Api.SET_GROUP_LEAVE,map);
    }

    /**
     * 设置群组专属头衔
     * param groupId 群号
     * param userId 要设置的QQ号
     * param specialTitle 专属头衔，不填或空字符串表示删除专属头衔
     * param duration 专属头衔有效期，单位秒，-1 表示永久，不过此项似乎没有效果，可能是只有某些特殊的时间长度有效，有待测试
     */
    public static void setGroupSpecialTitle(Long groupId, Long userId, String specialTitle, Integer duration){
        Map map = new HashMap();
        map.put("group_id", groupId);
        map.put("user_id", userId);
        map.put("special_title", specialTitle);
        map.put("duration", duration);
        ApiHandler.sendApiJson(Api.SET_GROUP_SPECIAL_TITLE,map);
    }

    /**
     * 处理加好友请求
     * param flag 加好友请求的 flag（需从上报的数据中获得）
     * param approve 是否同意请求
     * param remark 添加后的好友备注（仅在同意时有效）
     */
    public static void setFriendAddRequest(String flag, boolean approve, String remark){
        Map map = new HashMap();
        map.put("flag", flag);
        map.put("approve", approve);
        map.put("remark", remark);
        ApiHandler.sendApiJson(Api.SET_FRIEND_ADD_REQUEST,map);
    }

    /**
     * 处理加群请求／邀请
     * param flag 加群请求的 flag（需从上报的数据中获得）
     * param subType add或invite，请求类型（需要和上报消息中的sub_type字段相符）
     * param approve 是否同意请求／邀请，默认值true
     * param reason 拒绝理由（仅在拒绝时有效）
     */
    public static void setGroupAddRequest(String flag, String subType,boolean approve, String reason){
        Map map = new HashMap();
        map.put("flag", flag);
        map.put("sub_type", subType);
        map.put("approve", approve);
        map.put("reason", reason);
        ApiHandler.sendApiJson(Api.SET_GROUP_ADD_REQUEST,map);
    }

    /**
     * 获取登录号信息
     */
    public static ApiData<LoginInfoData> getLoginInfo(){
        return ApiHandler.sendApiJson(Api.GET_LOGIN_INFO,null).to(new TypeReference<ApiData<LoginInfoData>>() {
        });
    }

    /**
     * 获取陌生人信息
     * param userId QQ号
     * param noCache 是否不使用缓存（使用缓存可能更新不及时，但响应更快） 默认值false
     */
    public static ApiData<StrangerData> getStrangerInfo(Long userId, boolean noCache){
        Map map = new HashMap();
        map.put("user_id", userId);
        map.put("no_cache", noCache);
        return ApiHandler.sendApiJson(Api.GET_STRANGER_INFO,map).to(new TypeReference<ApiData<StrangerData>>() {
        });
    }

    /**
     * 获取好友列表
     */
    public static ApiData<List<FriendInfoData>> getFriendList(){
        return ApiHandler.sendApiJson(Api.GET_FRIEND_LIST,null).to(new TypeReference<ApiData<List<FriendInfoData>>>() {
        });
    }

    /**
     * 获取群信息
     * param groupId 群号
     * param noCache 是否不使用缓存（使用缓存可能更新不及时，但响应更快） 默认值false
     */
    public static ApiData<GroupInfoData> getGroupInfo(Long groupId, boolean noCache){
        Map map = new HashMap();
        map.put("group_id", groupId);
        map.put("no_cache", noCache);
        return ApiHandler.sendApiJson(Api.GET_GROUP_INFO,map).to(new TypeReference<ApiData<GroupInfoData>>() {
        });
    }

    /**
     * 获取群列表
     */
    public static ApiData<List<GroupInfoData>> getGroupList(){
        return ApiHandler.sendApiJson(Api.GET_GROUP_List,null).to(new TypeReference<ApiData<List<GroupInfoData>>>() {
        });
    }

    /**
     * 获取群成员信息
     * param groupId 群号
     * param userId QQ号
     * param noCache 是否不使用缓存（使用缓存可能更新不及时，但响应更快） 默认值false
     */
    public static ApiData<GroupMemberInfoData> getGroupMemberInfo(Long groupId, Long userId, boolean noCache){
        Map map = new HashMap();
        map.put("group_id", groupId);
        map.put("user_id", userId);
        map.put("no_cache", noCache);
        return ApiHandler.sendApiJson(Api.GET_GROUP_MEMBER_INFO,map).to(new TypeReference<ApiData<GroupMemberInfoData>>() {
        });
    }

    /**
     * 获取群成员列表
     * param groupId 群号
     */
    public static ApiData<List<GroupMemberInfoData>> getGroupMemberList(Long groupId){
        Map map = new HashMap();
        map.put("group_id", groupId);
        return ApiHandler.sendApiJson(Api.GET_GROUP_MEMBER_LIST,map).to(new TypeReference<ApiData<List<GroupMemberInfoData>>>() {
        });
    }

    /**
     * 获取群荣誉信息
     * param groupId 群号
     * param type 要获取的群荣誉类型，可传入talkative、performer、legend、strong_newbie、emotion以分别获取单个类型的群荣誉数据，或传入 all获取所有数据
     */
    public static ApiData<GroupHonorData> getGroupHonorInfo(Long groupId, String type){
        Map map = new HashMap();
        map.put("group_id", groupId);
        map.put("type", type);
        return ApiHandler.sendApiJson(Api.GET_GROUP_HONOR_INFO,map).to(new TypeReference<ApiData<GroupHonorData>>() {
        });
    }

    /**
     * 获取 Cookies
     * param domain 需要获取cookies的域名
     */
    public static ApiData<CookiesData> getCookies(String domain){
        Map map = new HashMap();
        map.put("domain", domain);
        return ApiHandler.sendApiJson(Api.GET_COOKIES,map).to(new TypeReference<ApiData<CookiesData>>() {
        });
    }

    /**
     * 获取CSRF Token
     */
    public static ApiData<CSRFTokenData> getCsrfToken(){
        return ApiHandler.sendApiJson(Api.GET_CSRF_TOKEN,null).to(new TypeReference<ApiData<CSRFTokenData>>() {
        });
    }

    /**
     * 获取QQ相关接口凭证
     * param domain 需要获取cookies的域名
     */
    public static ApiData<CredentialsData> getCredentials(String domain){
        Map map = new HashMap();
        map.put("domain", domain);
        return ApiHandler.sendApiJson(Api.GET_CREDENTIALS,map).to(new TypeReference<ApiData<CredentialsData>>() {
        });
    }

    /**
     * 获取语音
     * param file 收到的语音文件名（消息段的file参数），如0B38145AA44505000B38145AA4450500.silk
     * param outFormat 转换到的格式，目前支持mp3、amr、wma、m4a、spx、ogg、wav、flac
     */
    public static ApiData<FileData> getRecord(String file, String outFormat){
        Map map = new HashMap();
        map.put("file", file);
        map.put("out_format", outFormat);
        return ApiHandler.sendApiJson(Api.GET_RECORD,map).to(new TypeReference<ApiData<FileData>>() {
        });
    }

    /**
     * 获取图片
     * param file 收到的图片文件名（消息段的file参数），如6B4DE3DFD1BD271E3297859D41C530F5.jpg
     */
    public static ApiData<FileData> getImage(String file){
        Map map = new HashMap();
        map.put("file", file);
        return ApiHandler.sendApiJson(Api.GET_IMAGE,map).to(new TypeReference<ApiData<FileData>>() {
        });
    }

    /**
     * 检查是否可以发送图片
     */
    public static ApiData<ConformData> canSendImage(){
        return ApiHandler.sendApiJson(Api.CAN_SEND_IMAGE,null).to(new TypeReference<ApiData<ConformData>>() {
        });
    }

    /**
     * 检查是否可以发送语音
     */
    public static ApiData<ConformData> canSendRecord(){
        return ApiHandler.sendApiJson(Api.CAN_SEND_RECORD,null).to(new TypeReference<ApiData<ConformData>>() {
        });
    }

    /**
     * 获取运行状态
     */
    public static ApiData<StatusData> getStatus(){
        return ApiHandler.sendApiJson(Api.GET_STATUS,null).to(new TypeReference<ApiData<StatusData>>() {
        });
    }

    /**
     * 获取版本信息
     */
    public static ApiData<VersionInfoData> getVersionInfo(){
        return ApiHandler.sendApiJson(Api.GET_VERSION_INFO,null).to(new TypeReference<ApiData<VersionInfoData>>() {
        });
    }

    /**
     * 重启OneBot实现
     * param delay 要延迟的毫秒数，如果默认情况下无法重启，可以尝试设置延迟为2000左右
     */
    public static void setRestart(Integer delay){
        Map map = new HashMap();
        map.put("delay", delay);
        ApiHandler.sendApiJson(Api.SET_RESTART,map);
    }

    /**
     * 清理缓存
     */
    public static void cleanCache(){
        ApiHandler.sendApiJson(Api.CLEAN_CACHE,null);
    }

    /**
     * 封装信息
     * param api
     * param params
     * return
     */
    private static ApiResult getApiResult(Api api, Map params){
        ApiResult result = new ApiResult();
        //封装result
        result.setAction(api.getAction());
        result.setParams(params);
        return result;
    }
}
