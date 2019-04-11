/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.strategy.samplexichuan;

/**
 * 攻取西川参谋部，就是上下文啦，由上下文来选择具体的策略
 *
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/9 11:52
 */
public class OccupationContext {
    public void occupationWestOfSiChuan(String msg) {
        //先用上上策
        IOccupationStrategy strategy = new UpperOccupationStrategy();
        try {
            strategy.occupationWestOfSiChuan(msg);
        } catch (Exception e) {
            //上上计策有问题行不通之后，用中计策
            strategy = new MiddleOccupationStrategy();
            strategy.occupationWestOfSiChuan(msg);
        }
    }
}
