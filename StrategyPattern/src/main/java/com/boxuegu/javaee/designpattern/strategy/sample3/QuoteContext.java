/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.strategy.sample3;

import java.math.BigDecimal;

/**
 * 报价上下文角色
 *
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/9 11:35
 */
public class QuoteContext {
    private final String newCustomer = "新客户";
    private final String oldCustomer = "老客户";
    private final String vipCustomer = "VIP客户";
    /**
     * 持有一个具体的报价策略
     */
    private IQuoteStrategy quoteStrategy;

    /**
     * 注入报价策略
     *
     * @param quoteStrategy
     */
    public QuoteContext(IQuoteStrategy quoteStrategy) {
        this.quoteStrategy = quoteStrategy;
    }

    /**
     * 注入报价策略
     *
     * @param customerType
     */
    public QuoteContext(String customerType) {
        if (newCustomer.equals((customerType))) {
            this.quoteStrategy = new NewCustomerQuoteStrategy();
        } else if (oldCustomer.equals(customerType)) {
            this.quoteStrategy = new OldCustomerQuoteStrategy();

        } else if (vipCustomer.equals(customerType)) {
            this.quoteStrategy = new VipCustomerQuoteStrategy();
        }
        this.quoteStrategy = new NewCustomerQuoteStrategy();
    }

    /**
     * 回调具体报价策略的方法
     *
     * @param originalPrice
     * @return
     */
    public BigDecimal getPrice(BigDecimal originalPrice) {
        return quoteStrategy.quote(originalPrice);
    }
}
