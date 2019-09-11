package com.example.demo.gui;
 
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
 
/**
* @ClassName: TestGui4
* @Description: 
* @Author: York 
* @Date: 2018/7/10 0010 10:06
* @Version: V1.0
*/
public class TestGui4 {
    public static void main(String[] args) {
 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 400);
        f.setLocation(200, 200);
 
        JMenuBar mb = new JMenuBar();
 
        JMenu mHero = new JMenu("英雄");
        JMenu mItem = new JMenu("道具");
        JMenu mWord = new JMenu("符文");
        JMenu mSummon = new JMenu("召唤师");
        JMenu mTalent = new JMenu("天赋树");
 
        // 菜单项
        mHero.add(new JMenuItem("近战-Warriar"));
        mHero.add(new JMenuItem("远程-Range"));
        mHero.add(new JMenuItem("物理-physical"));
        mHero.add(new JMenuItem("坦克-Tank"));
        mHero.add(new JMenuItem("法系-Mage"));
        mHero.add(new JMenuItem("辅助-Support"));
        mHero.add(new JMenuItem("打野-Jungle"));
        mHero.add(new JMenuItem("突进-Charge"));
        mHero.add(new JMenuItem("男性-Boy"));
        mHero.add(new JMenuItem("女性-Girl"));
        // 分隔符
        mHero.addSeparator();
        mHero.add(new JMenuItem("所有-All"));
 
        mb.add(mHero);
        mb.add(mItem);
        mb.add(mWord);
        mb.add(mSummon);
        mb.add(mTalent);
 
        f.setJMenuBar(mb);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
}