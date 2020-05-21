package com.example.demo.gui;
 
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
 
/**
* @ClassName: TestGui3
* @Description: 
* @Author: York 
* @Date: 2018/7/10 0010 10:07
* @Version: V1.0
*/
public class TestGui3 {
    public static void main(String[] args) {
 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
 
        f.setLayout(new FlowLayout());
 
        JProgressBar pb = new JProgressBar();
 
        //进度条最大100
        pb.setMaximum(100);
        //当前进度是50
        pb.setValue(50);
        //显示当前进度
        pb.setStringPainted(true);
 
        f.add(pb);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
}