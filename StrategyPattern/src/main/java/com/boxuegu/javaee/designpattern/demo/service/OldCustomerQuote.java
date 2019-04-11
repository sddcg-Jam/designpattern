/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.demo.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/10 11:29
 */
@Service
public class OldCustomerQuote implements IQuote {

    @Override
    public String getCustomerType() {
        return "老客户";
    }
    @Override
    public String quote(BigDecimal originalPrice){
        return originalPrice.multiply(new BigDecimal(0.9)).setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString();
    }
}
