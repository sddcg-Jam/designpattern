/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.demo.service;

import java.math.BigDecimal;

/**
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/10 11:42
 */
public class CustomerQuoteContext {
    public IQuote quote;

    public CustomerQuoteContext(IQuote quote) {
        this.quote = quote;
    }

    public CustomerQuoteContext(String customerType) {
        this.quote = IQuote.map.get(customerType);
    }

    public String getPrice(BigDecimal originalPrice) {
        return quote.quote(originalPrice);
    }

    public IQuote getQuote() {
        return quote;
    }

    public void setQuote(IQuote quote) {
        this.quote = quote;
    }
}
