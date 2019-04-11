/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.strategy.standard;

/**
 * 外部客户端
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/9 9:57
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        //1.创建具体测策略实现
        IStrategy strategy=new ConcreteStrategyA();
        //2.在创建策略上下文的同时，将具体的策略实现对象注入到策略上下文当中
        StrategyContext context = new StrategyContext(strategy);
        //3.调用上下文对象的方法来完成对具体策略实现的回调
        String returnStr=context.executeStrategy("第一次");
        System.out.println(returnStr);

        context = new StrategyContext(new ConcreteStrategyB());
        returnStr=context.executeStrategy("第二次");
        System.out.println(returnStr);

        context = new StrategyContext(new ConcreteStrategyC());
        returnStr=context.executeStrategy("第三次");
        System.out.println(returnStr);
    }
}
