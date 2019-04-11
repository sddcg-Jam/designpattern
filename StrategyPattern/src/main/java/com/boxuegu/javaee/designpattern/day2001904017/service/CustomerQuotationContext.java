/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.day2001904017.service;

import java.math.BigDecimal;

/**
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/10 19:41
 */
public class CustomerQuotationContext {
    ICustomerQuotation customerQuotation;

    public CustomerQuotationContext(ICustomerQuotation customerQuotation) {
        this.customerQuotation = customerQuotation;
    }

    public CustomerQuotationContext(String customerType) {
        this.customerQuotation = ICustomerQuotation.map.get(customerType);
    }

    public BigDecimal getPrice(BigDecimal originalPrice) {
        System.out.println("通过上下文方式进行调用");
        return customerQuotation.quotation(originalPrice);
    }

}
