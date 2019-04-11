/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.strategy.samplexichuan;

/**
 * 此时外部客户端相当于刘备了,不管具体采用什么计策，只要结果（成功的攻下西川）
 *
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/9 11:55
 */
public class Client {
    public static void main(String[] args) {
        OccupationContext context = new OccupationContext();
        //这个给手下的人激励不够啊
        context.occupationWestOfSiChuan("拿下西川");
        System.out.println("=========================");
        //这个人人有赏，让士兵有动力啊
        context.occupationWestOfSiChuan("拿下西川之后，人人有赏！");
    }
}
