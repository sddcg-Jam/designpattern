/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.strategy.sample3;

import java.math.BigDecimal;

/**
 * 新客户的报价策略实现类
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/9 11:29
 */
public class NewCustomerQuoteStrategy implements IQuoteStrategy {
    @Override
    public BigDecimal quote(BigDecimal originalPrice) {
        System.out.println("抱歉，新用户没有折扣");
        return originalPrice;
    }
}
