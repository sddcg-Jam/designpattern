/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.demo.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/10 11:32
 */
@Service
public class VipCustomerQuote implements IQuote {

    @Override
    public String getCustomerType() {
        return "VIP客户";
    }

    @Override
    public String quote(BigDecimal originalPrice) {
        return originalPrice.multiply(new BigDecimal(0.8)).setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
    }
}
