/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.strategy.samplepay;

import com.boxuegu.javaee.designpattern.strategy.samplepay.impl.AbstractCard;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/8 18:01
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationcontext.xml");
        context.start();
        AbstractCard.cardMap.get(Constant.CREDIT_CARD).pay(10000);
    }
}
