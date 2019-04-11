/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.demo.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/10 11:21
 */
@Service
public class PriceQuote {
    public String quote(BigDecimal originalPrice, String customerType) {
        if ("新客户".equalsIgnoreCase(customerType)) {
            return quoteNewCustomer(originalPrice);
        } else if ("老客户".equalsIgnoreCase(customerType)) {
            return quoteOldCustomer(originalPrice);
        } else if ("VIP客户".equalsIgnoreCase(customerType)) {
            return quoteVIPCustomer(originalPrice);
        }
        return originalPrice.toPlainString();
    }

    public String quoteNewCustomer(BigDecimal originalPrice) {
        return originalPrice.toPlainString();
    }

    public String quoteOldCustomer(BigDecimal originalPrice) {
        return originalPrice.multiply(new BigDecimal(0.9)).setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
    }

    public String quoteVIPCustomer(BigDecimal originalPrice) {
        return originalPrice.multiply(new BigDecimal(0.8)).setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
    }
}
