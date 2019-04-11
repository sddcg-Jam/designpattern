/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.day20190417.service;

import com.boxuegu.javaee.designpattern.day20190417.util.Constant;

import java.math.BigDecimal;

/**
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/11 16:19
 */
public class CustomerQuotationContext {
    private ICustomerQuotation quotation;

    public CustomerQuotationContext(ICustomerQuotation quotation) {
        this.quotation = quotation;
    }

    public CustomerQuotationContext(String customerType) {
        this.quotation = ICustomerQuotation.map.get(customerType);
        if (this.quotation == null) {
            quotation = ICustomerQuotation.map.get(Constant.NEW);
        }

    }

    public String getPrice(BigDecimal originalPrice) {
        System.out.println("进行一些前置处理");
        BigDecimal price = quotation.getQuotation(originalPrice);
        price = price.add(quotation.getShippingFee()).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("进行一些后置处理");
        return price.toPlainString();
    }
}
