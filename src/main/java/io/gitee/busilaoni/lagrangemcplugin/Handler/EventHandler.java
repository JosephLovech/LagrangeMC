package io.gitee.busilaoni.lagrangemcplugin.Handler;

import com.alibaba.fastjson2.JSONObject;
import io.gitee.busilaoni.lagrangemcplugin.Bot.BotPlugin;
import io.gitee.busilaoni.lagrangemcplugin.Event.Message.GroupMessageEvent;
import io.gitee.busilaoni.lagrangemcplugin.Event.Message.PrivateMessageEvent;
import io.gitee.busilaoni.lagrangemcplugin.Event.Meta.HeartbeatMetaEvent;
import io.gitee.busilaoni.lagrangemcplugin.Event.Meta.LifecycleMetaEvent;
import io.gitee.busilaoni.lagrangemcplugin.Event.Notice.*;
import io.gitee.busilaoni.lagrangemcplugin.Event.Request.FriendRequestEvent;
import io.gitee.busilaoni.lagrangemcplugin.Event.Request.GroupRequestEvent;
import org.bukkit.Bukkit;

import java.util.function.Function;

/**
 * 事件处理器，用于处理机器人接收到的各种事件，例如私聊消息、群消息、群成员增加/减少等。
 */
public class EventHandler {

    /**
     * 处理事件
     * param jsonObject 事件JSON对象
     */
    public void handler(JSONObject jsonObject){
        //获取postType类型
        String postType = jsonObject.getString("post_type");

        //postType参数为null时
        if (postType == null){
            Bukkit.getLogger().warning(String.format("postType is null: %s",jsonObject.toString()));
            return;
        }

        // 根据事件类型分发到不同的处理方法中
        switch (postType) {
            // 如果是消息事件，则调用 handleMessage 方法处理
            case "message":
                handleMessage(jsonObject);
            break;

            // 如果是元事件，则调用 handleMeta 方法处理
            case "meta_event":
                handleMeta(jsonObject);
            break;

            // 如果是通知事件，则调用 handleNotice 方法处理
            case "notice":
                handleNotice(jsonObject);
            break;

            // 如果是请求事件，则调用 handleRequest 方法处理
            case "request":
                handleRequest(jsonObject);
            break;

            // 未知事件类型
            default:
                Bukkit.getLogger().warning(String.format("Unknown post_type: %s",jsonObject.toString()));
            break;
        }
    }

    /**
     * 处理接受到的消息
     * param jsonObject
     */
    private void handleMessage(JSONObject jsonObject){

        //获取messageType类型
        String messageType = jsonObject.getString("message_type");

        switch (messageType){

            /**
             * 私聊消息
             */
            case "private":
                //消息转换对应类型
                PrivateMessageEvent privateMessageEvent = jsonObject.toJavaObject(PrivateMessageEvent.class);
                //转发执行
                handlePluginMessages(botPlugin -> botPlugin.onPrivateMessage(privateMessageEvent));
            break;

            /**
             * 群聊消息
             */
            case "group":

                //消息转换对应类型
                GroupMessageEvent groupMessageEvent = jsonObject.toJavaObject(GroupMessageEvent.class);
                //转发执行
                handlePluginMessages(botPlugin -> botPlugin.onGroupMessage(groupMessageEvent));
            break;

            /**
             * 其他消息
             */
            default:
                Bukkit.getLogger().warning(String.format("Unknown message_type: %s",jsonObject.toString()));
            break;
        }
    }

    /**
     * 处理接受到的元事件
     * param jsonObject
     */
    private void handleMeta(JSONObject jsonObject){

        //获取metaEventType类型
        String metaEventType = jsonObject.getString("meta_event_type");

        switch (metaEventType){

            /**
             * 生命周期
             */
            case "lifecycle":
                //消息转换对应类型
                LifecycleMetaEvent lifecycleMetaEvent = jsonObject.toJavaObject(LifecycleMetaEvent.class);
                //转发执行
                handlePluginMessages(botPlugin -> botPlugin.onLifecycleMeta(lifecycleMetaEvent));
            break;

            /**
             * 心跳
             */
            case "heartbeat":

                //消息转换对应类型
                HeartbeatMetaEvent heartbeatMetaEvent = jsonObject.toJavaObject(HeartbeatMetaEvent.class);
                //转发执行
                handlePluginMessages(botPlugin -> botPlugin.onHeartbeatMeta(heartbeatMetaEvent));
            break;

            /**
             * 其他消息
             */
            default:
                Bukkit.getLogger().warning(String.format("Unknown meta_event_type: %s",jsonObject.toString()));
            break;
        }
    }


    /**
     * 处理接受到的通知
     * param jsonObject
     */
    private void handleNotice(JSONObject jsonObject){

        //获取messageType类型
        String noticeType = jsonObject.getString("notice_type");

        switch (noticeType){

            /**
             * 群文件上传
             */
            case "group_upload":
                //消息转换对应类型
                GroupFileUploadNoticeEvent groupFileUploadNoticeEvent = jsonObject.toJavaObject(GroupFileUploadNoticeEvent.class);
                //转发执行
                handlePluginMessages(botPlugin -> botPlugin.onGroupFileUpload(groupFileUploadNoticeEvent));
            break;

            /**
             * 群管理员变动
             */
            case "group_admin":

                //消息转换对应类型
                GroupAdminChangeNoticeEvent groupAdminChangeNoticeEvent = jsonObject.toJavaObject(GroupAdminChangeNoticeEvent.class);
                //转发执行
                handlePluginMessages(botPlugin -> botPlugin.onGroupAdminChange(groupAdminChangeNoticeEvent));
            break;

            /**
             * 群成员减少
             */
            case "group_decrease":

                //消息转换对应类型
                GroupDecreaseNoticeEvent groupDecreaseNoticeEvent = jsonObject.toJavaObject(GroupDecreaseNoticeEvent.class);
                //转发执行
                handlePluginMessages(botPlugin -> botPlugin.onGroupDecrease(groupDecreaseNoticeEvent));
            break;

            /**
             * 群成员增加
             */
            case "group_Increase":

                //消息转换对应类型
                GroupIncreaseNoticeEvent groupIncreaseNoticeEvent = jsonObject.toJavaObject(GroupIncreaseNoticeEvent.class);
                //转发执行
                handlePluginMessages(botPlugin -> botPlugin.onGroupIncrease(groupIncreaseNoticeEvent));
            break;

            /**
             * 群禁言
             */
            case "group_ban":

                //消息转换对应类型
                GroupBanNoticeEvent groupBanNoticeEvent = jsonObject.toJavaObject(GroupBanNoticeEvent.class);
                //转发执行
                handlePluginMessages(botPlugin -> botPlugin.onGroupBan(groupBanNoticeEvent));
            break;

            /**
             * 好友添加
             */
            case "friend_add":

                //消息转换对应类型
                FriendAddNoticeEvent friendAddNoticeEvent = jsonObject.toJavaObject(FriendAddNoticeEvent.class);
                //转发执行
                handlePluginMessages(botPlugin -> botPlugin.onFriendAdd(friendAddNoticeEvent));
            break;


            /**
             * 群消息撤回
             */
            case "group_recall":

                //消息转换对应类型
                GroupRecallNoticeEvent groupRecallNoticeEvent = jsonObject.toJavaObject(GroupRecallNoticeEvent.class);
                //转发执行
                handlePluginMessages(botPlugin -> botPlugin.onGroupRecall(groupRecallNoticeEvent));
            break;

            /**
             * 好友消息撤回
             */
            case "friend_recall":

                //消息转换对应类型
                FriendRecallNoticeEvent friendRecallNoticeEvent = jsonObject.toJavaObject(FriendRecallNoticeEvent.class);
                //转发执行
                handlePluginMessages(botPlugin -> botPlugin.onFriendRecall(friendRecallNoticeEvent));
            break;

            /**
             * 通知
             */
            case "notify":

                //通知类型筛选 群内戳一戳、群红包运气王、群成员荣誉变更
                String subType = jsonObject.getString("sub_type");

                switch (subType){

                    /**
                     * 群内戳一戳
                     */
                    case "poke":
                        //消息转换对应类型
                        GroupPokeNoticeEvent groupPokeNoticeEvent = jsonObject.toJavaObject(GroupPokeNoticeEvent.class);
                        //转发执行
                        handlePluginMessages(botPlugin -> botPlugin.onGroupPoke(groupPokeNoticeEvent));
                    break;

                    /**
                     * 群红包运气王
                     */
                    case "lucky_king":
                        //消息转换对应类型
                        GroupLuckyKingNoticeEvent groupLuckyKingNoticeEvent = jsonObject.toJavaObject(GroupLuckyKingNoticeEvent.class);
                        //转发执行
                        handlePluginMessages(botPlugin -> botPlugin.onGroupLuckKing(groupLuckyKingNoticeEvent));
                    break;

                    /**
                     * 群成员荣誉变更
                     */
                    case "honor":
                        //消息转换对应类型
                        GroupHonorChangeNoticeEvent groupHonorChangeNoticeEvent = jsonObject.toJavaObject(GroupHonorChangeNoticeEvent.class);
                        //转发执行
                        handlePluginMessages(botPlugin -> botPlugin.onGroupHonorChange(groupHonorChangeNoticeEvent));
                    break;

                    /**
                     * 其他消息
                     */
                    default:
                        Bukkit.getLogger().warning(String.format("Unknown sub_type: %s",jsonObject.toString()));
                    break;
                }
            break;

            /**
             * 其他消息
             */
            default:
                Bukkit.getLogger().warning(String.format("Unknown request_type: %s",jsonObject.toString()));
             break;
        }
    }

    /**
     * 处理接受到的请求
     * param jsonObject
     */
    private void handleRequest(JSONObject jsonObject){

        //获取messageType类型
        String requestType = jsonObject.getString("request_type");

        switch (requestType){

            /**
             * 加好友请求
             */
            case "friend":
                //消息转换对应类型
                FriendRequestEvent friendRequestEvent = jsonObject.toJavaObject(FriendRequestEvent.class);
                //转发执行
                handlePluginMessages(botPlugin -> botPlugin.onFriendRequest(friendRequestEvent));
            break;

            /**
             * 加群请求/邀请
             */
            case "group":
                //消息转换对应类型
                GroupRequestEvent groupRequestEvent = jsonObject.toJavaObject(GroupRequestEvent.class);
                //转发执行
                handlePluginMessages(botPlugin -> botPlugin.onGroupRequest(groupRequestEvent));
            break;

            /**
             * 其他消息
             */
            default:
                Bukkit.getLogger().warning(String.format("Unknown message_type: %s",jsonObject.toString()));
            break;
        }
    }

    /**
     * 处理插件消息。
     * 处理方法，接受一个 BotPlugin 参数，并返回一个整数结果
     * param action
     */
    private void handlePluginMessages(Function<BotPlugin, Integer> action) {

        //遍历插件列表
        for (Class<? extends BotPlugin> pluginClass : BotPlugin.pluginList) {

            //转换为实例对象
            BotPlugin plugin = getPlugin(pluginClass);

            //执行插件
            if (plugin != null && action.apply(plugin) == BotPlugin.MatchedAndBlock) {
                return;
            }
        }
    }

    /**
     * 获取指定类型的插件实例。
     * param clazz 插件类型
     * param <T> 插件类型参数
     * return 插件实例，如果不存在，则返回 null
     */
    private <T> T getPlugin(Class<T> clazz) {
        try {
            //反射获取实例对象
            return clazz.getConstructor().newInstance();
        } catch (Exception e) {
            Bukkit.getLogger().info(String.format("获取插件：%s出错",clazz.toString()));
            return null;
        }
    }
}
