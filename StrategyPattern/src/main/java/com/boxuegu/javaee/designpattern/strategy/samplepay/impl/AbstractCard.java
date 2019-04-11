/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.strategy.samplepay.impl;

import com.boxuegu.javaee.designpattern.strategy.samplepay.PayMethod;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/8 18:01
 */
public abstract class AbstractCard implements PayMethod {
    /**
     * 用来记录当前抽象类型的所有支付渠道
     */
    public static Map<String, AbstractCard> cardMap = new ConcurrentHashMap<>();
    private String name;
    private String number;

    public AbstractCard() {
    }

    public AbstractCard(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @PostConstruct
    public void init() {
        cardMap.put(getType(), this);
    }

    @Override
    public void pay(int cents) {
        execTransaction(cents);
//        System.out.println("使用卡支付");
    }

    /**
     * 执行交易
     *
     * @param cents
     */
    protected abstract void execTransaction(int cents);

    /**
     * 获取类型
     *
     * @return
     */
    protected abstract String getType();
}
