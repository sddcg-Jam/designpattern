/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.day20190417.jdksample;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.GridLayout;

/**
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/10 20:28
 */
public class ContainerTest {
    public static void main(String[] args) {
        JFrame window =new JFrame("窗口");
        Container con=window.getContentPane();
        window.setBounds(550,250,300,260);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //window.setLayout(new FlowLayout());
        window.setLayout(new GridLayout(3,1));
        JLabel l1=new JLabel("姓名：");
        window.add(l1);
        JTextField text=new JTextField(10);
        window.add(text);
        JButton button=new JButton("确定");
        window.add(button);
        window.setVisible(true);
    }
}

