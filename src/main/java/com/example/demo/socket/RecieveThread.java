package com.example.demo.socket;
 
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
* @ClassName: RecieveThread
* @Description:
* @Author: York
* @Date: 2018/7/10 0010 9:56
* @Version: V1.0
*/
public class RecieveThread extends Thread {
 
    private Socket s;
 
    public RecieveThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            InputStream is = s.getInputStream();
 
            DataInputStream dis = new DataInputStream(is);
            while (true) {
                String msg = dis.readUTF();
                System.out.println(msg);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
 
}