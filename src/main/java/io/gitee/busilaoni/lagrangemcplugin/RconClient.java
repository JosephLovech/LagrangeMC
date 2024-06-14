package io.gitee.busilaoni.lagrangemcplugin;

import lombok.Data;
import nl.vv32.rcon.Rcon;

import java.io.IOException;

@Data
public class RconClient {
    /**
     * Rcon对象
     */
    private Rcon rcon;

    /**
     * 端口
     */
    private Integer port;

    /**
     * 服务器ip
     */
    private String host;

    /**
     * 密码
     */
    private String password;

    /**
     * 是否开启连接
     */
    private boolean isOpen = false;

    /**
     * 构造器中配置信息，port为null时默认使用25575端口
     *
     * @param port rcon端口号
     * @param host 服务器地址
     * @param password 密码
     */
    public RconClient(Integer port, String host, String password){

        if (port == null){
            this.port = 25575;
        }

        this.port = port;
        this.host = host;
        this.password = password;
    }

    /**
     * rcon连接
     */
    private void connect(){
        try {
            rcon = Rcon.open(host,port);

            if (rcon.authenticate(password)){
                System.out.println("rcon成功连接");
                isOpen = true;
            }else {
                System.out.println("rcon连接失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送指令
     *
     * @param command 命令
     * @return 返回信息
     */
    public String sendCommand(String command){

        try {

            //判断是否连接到Rcon
            if (!isOpen){
                connect();
            }
            return rcon.sendCommand(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "发送命令错误";
    }
}
