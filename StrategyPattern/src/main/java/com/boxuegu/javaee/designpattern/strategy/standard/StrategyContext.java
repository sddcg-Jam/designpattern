/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.strategy.standard;

/**
 * 策略上下文角色StrategyContext:策略上下文，负责和具体的策略实现交互，通常策略上下文对象会持有一个真正的策略实现对象，策略上下文还可以让具体的策略实现从其中获取相关数据，回调策略上下文对象的方法。
 *
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/9 9:47
 */
public class StrategyContext {
    /**
     * 持有一个策略实现的引用
     */
    IStrategy strategy;

    /**
     * 使用构造器注入具体的策略类
     *
     * @param strategy
     */
    public StrategyContext(IStrategy strategy) {
        this.strategy = strategy;
    }

    public String executeStrategy(String arg) {

        //调用策略实现的方法
        return strategy.doSomething(arg);
    }
}
