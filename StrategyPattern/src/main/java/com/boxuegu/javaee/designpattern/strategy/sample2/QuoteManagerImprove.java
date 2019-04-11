/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.strategy.sample2;

import java.math.BigDecimal;

/**
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/8 18:01
 */
public class QuoteManagerImprove {

    private final String newCustomer = "新客户";
    private final String oldCustomer = "老客户";
    private final String vipCustomer = "VIP客户";

    public BigDecimal quote(BigDecimal originalPrice, String customerType) {
        if (newCustomer.equals((customerType))) {
            return quoteNewCustomer(originalPrice);
        } else if (oldCustomer.equals(customerType)) {
            return quoteOldCustomer(originalPrice);

        } else if (vipCustomer.equals(customerType)) {
            return quoteVIPCustomer(originalPrice);
        }
        //其他人员都是原价
        return originalPrice;
    }

    private BigDecimal quoteNewCustomer(BigDecimal originalPrice) {
        System.out.println("抱歉，新用户没有折扣");
        return originalPrice;
    }

    /**
     * 对老客户的报价算法
     *
     * @param originalPrice 原价
     * @return 折后价
     */
    private BigDecimal quoteOldCustomer(BigDecimal originalPrice) {
        System.out.println("恭喜你老客户打九折");
        return originalPrice.multiply(new BigDecimal(0.9)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 对VIP客户的报价算法
     *
     * @param originalPrice 原价
     * @return 折后价
     */
    private BigDecimal quoteVIPCustomer(BigDecimal originalPrice) {
        System.out.println("恭喜你！VIP客户打8折");
        return originalPrice.multiply(new BigDecimal(0.8)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
