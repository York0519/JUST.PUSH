package com.example.demo.socket;
 
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
* @ClassName: SendThread
* @Description:
* @Author: York
* @Date: 2018/7/10 0010 10:02
* @Version: V1.0
*/
public class SendThread extends Thread{
 
    private Socket s;
 
    public SendThread(Socket s){
        this.s = s;
    }
    @Override
    @SuppressWarnings("resource")
	public void run(){
        try {
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
 
            while(true){
                Scanner sc = new Scanner(System.in);
                String str = sc.next();
                dos.writeUTF(str);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
    }
     
}