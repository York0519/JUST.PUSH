package com.example.demo.socket;
 
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
* @ClassName: Client
* @Description:
* @Author: York
* @Date: 2018/7/10 0010 10:00
* @Version: V1.0
*/
public class Client {
 
    public static void main(String[] args) {
 
        try {
            Socket s = new Socket("127.0.0.1", 8888);
 
            // 启动发送消息线程
            new SendThread(s).start();
            // 启动接受消息线程
            new RecieveThread(s).start();
 
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}