## 基于Lagrange.Core的MC插件框架



#### 相关链接

Lagrange.Core核心 https://github.com/LagrangeDev/Lagrange.Core

OneBot11协议 https://github.com/botuniverse/onebot-11/tree/master

go-cqhttp的javaWebsocket框架 https://gitee.com/changwenpeng/svipbot



推荐使用Lagrange.Core机器人核心或支持onebot11协议的机器人核心

0.0.6支持多个机器人

0.0.7删除框架中的paperAPI



开启机器人时选择反向websocket

#### 框架引用

maven

~~~maven
<dependency>
   <groupId>io.gitee.soulgoodmans</groupId>
   <artifactId>LagrangeMCPlugin</artifactId>
   <version>0.0.7</version>
</dependency>
~~~



gradle

~~~gradle
dependencies {
    implementation 'io.gitee.soulgoodmans:LagrangeMCPlugin:0.0.7'
}
~~~



#### MC插件部分

yml配置

~~~config.yml
#websocket配置
websocket:
  #打开的端口
  port: 9000

#连接rcon配置
rcon:
  #端口号，默认25575
  port: 25575
  #服务器ip
  host: localhost
  #密码
  password: 114514
~~~





javaPlugin类

~~~java
public final class LagrangeMCExample extends JavaPlugin {

    private YamlConfiguration yamlConfig;

    private SocketServer server;

    private RconClient rconClient;

    @Override
    public void onEnable() {

        //加载配置文件 config.yml
        File file = new File(getDataFolder(), "config.yml");
        if (!file.exists()){
            file.getParentFile().mkdirs();
            saveResource("config.yml",false);
        }

        //配置变量对象
        yamlConfig = YamlConfiguration.loadConfiguration(file);

        //配置websocket
        server = new SocketServer(yamlConfig.getInt("websocket.port"));
        server.start();

        //配置Rcon 如果不需要可以不用添加
        rconClient = new RconClient(
         	yamlConfig.getInt("rcon.port"),
            yamlConfig.getString("rcon.host"),
            yamlConfig.getString("rcon.password")
        );

        //加载插件列表 List<Class>结合
        BotPlugin.pluginList.add(MessagePlugin.class);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
~~~



插件类

~~~java
/**
 * 消息插件
 */
public class MessagePlugin extends BotPlugin {

    /**
     * 接收私聊消息
     * @param event 事件内容
     * @return
     */
    @Override
    public int onPrivateMessage(Bot bot, PrivateMessageEvent event) {

        //构建信息
        CQMsg msg = new CQMsg();
        msg.Text("你好").QQFace(14);

        //机器人发送信息
        bot.sendPrivateMessage(event.getUserId(),msg.toString(),false);
        return NotMatch;
    }

    /**
     * 接收群消息
     * @param event 事件内容
     * @return
     */
    @Override
    public int onGroupMessage(Bot bot, GroupMessageEvent event) {

        //构建信息
        CQMsg msg = new CQMsg();
        msg.Text("你好").QQFace(14);

        //机器人发送群信息
        bot.sendGroupMessage(event.getGroupId(),msg.toString(),false);
        return NotMatch;
    }
}
~~~



针对机器人发送信息使用静态方法 例：Bot.sendGroupMessage() ，所以可以在MC监听器中使用

~~~java
public class PlayerJoinListener implements Listener {

    /**
     * 玩家进入游戏监听
     * param event
     */
    @EventHandler
    public void playerJoin(PlayerJoinEvent event){

        //构建信息
        CQMsg msg = new CQMsg();
        msg.Text(String.format("%s 加入游戏", event.getPlayer().getName()));
        
        //通过qq号从容器中获取机器人
        BotContainer.getBot(1008611L).sendGroupMessage(10010L,msg.toString(),false);
    }
}
~~~



或者也可以在命令中使用

~~~java
public class SendMsgCommand implements CommandExecutor {

    /**
     * 发送命令
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        
        //构建信息
        CQMsg msg = new CQMsg();
        msg.Text(args[0]);
        
        //通过qq号从容器中获取机器人
        BotContainer.getBot(1008611L).sendGroupMessage(10010L,msg.toString(),false);
        return true;
    }
}
~~~





#### 关于

代码大量参考于 https://gitee.com/changwenpeng/svipbot

部分bug未排查到，如果遇到请提交到issure中。
