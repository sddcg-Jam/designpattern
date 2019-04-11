/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.strategy.standard;

/**
 * 策略接口角色IStrategy:用来约束一系列具体的策略算法,策略上下文角色ConcreteStrategy使用此策略接口来调用具体的策略所实现的算法。
 *
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/9 9:39
 */
public interface IStrategy {
    /**
     * 定义的抽象算法方法 来约束具体的算法实现方法
     *
     * @param arg
     * @return
     */
    public String doSomething(String arg);
}
