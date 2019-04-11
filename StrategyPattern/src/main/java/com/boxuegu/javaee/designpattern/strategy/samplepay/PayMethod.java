/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.strategy.samplepay;

/**
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/8 18:01
 */
public interface PayMethod {
    /**
     * 支付接口
     *
     * @param cents
     */
    public void pay(int cents);
}
