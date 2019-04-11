/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.strategy.sample3;

import java.math.BigDecimal;

/**
 * 老客户的报价策略实现
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/9 11:31
 */
public class OldCustomerQuoteStrategy implements IQuoteStrategy {
    @Override
    public BigDecimal quote(BigDecimal originalPrice) {
        System.out.println("恭喜你老客户打九折");
        return originalPrice.multiply(new BigDecimal(0.9)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
