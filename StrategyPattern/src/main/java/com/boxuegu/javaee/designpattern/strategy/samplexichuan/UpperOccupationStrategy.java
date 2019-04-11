/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.strategy.samplexichuan;

/**
 * 上策：挑选精兵，昼夜兼行直接偷袭成都，可以一举而定，此为上计计也。
 *
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/9 11:46
 */
public class UpperOccupationStrategy implements IOccupationStrategy {
    @Override
    public void occupationWestOfSiChuan(String msg) {
        if (msg == null || msg.length() < 5) {
            //故意设置障碍，导致上上计策失败
            System.out.println("由于计划泄露，上上策失败！");
            int i = 100 / 0;
        }
        System.out.println("挑选精兵，昼夜兼行直接偷袭成都，可以一举而定，此为上计计也");
    }
}
