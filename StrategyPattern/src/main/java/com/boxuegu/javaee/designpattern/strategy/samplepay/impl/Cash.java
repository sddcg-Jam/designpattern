/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.strategy.samplepay.impl;

import com.boxuegu.javaee.designpattern.strategy.samplepay.PayMethod;

/**
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/8 18:01
 */
public class Cash implements PayMethod {
    @Override
    public void pay(int cents) {
        System.out.println("现金支付：" + cents + "");
    }
}
