/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.strategy.samplepay.impl;

import com.boxuegu.javaee.designpattern.strategy.samplepay.Constant;
import org.springframework.stereotype.Service;

/**
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/8 18:01
 */
@Service
public class CreditCard extends AbstractCard {
    @Override
    protected void execTransaction(int cents) {
        System.out.println("当前支付方式是：[" + getType() + "]，金额：[" + cents + "]");
    }

    @Override
    protected String getType() {
        return Constant.CREDIT_CARD;
    }
}
