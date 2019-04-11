/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.strategy.standard;

/**
 * 具体策略实现角色ConcreteStrategy:具体的策略实现，即具体的算法实现。
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/9 9:46
 */
public class ConcreteStrategyC implements IStrategy {
    @Override
    public String doSomething(String arg) {
        return "具体策略C返回：" + arg;
    }
}
