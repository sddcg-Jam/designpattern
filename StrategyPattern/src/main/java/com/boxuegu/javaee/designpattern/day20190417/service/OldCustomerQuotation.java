/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.day20190417.service;

import com.boxuegu.javaee.designpattern.day20190417.util.Constant;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/11 16:13
 */

@Service
public class OldCustomerQuotation implements ICustomerQuotation {
    @Override
    public BigDecimal getQuotation(BigDecimal originalPrice) {
        return originalPrice.multiply(new BigDecimal(0.9)).setScale(2,BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public String getCustomerType() {
        return Constant.OLD;
    }
    @Override
    public BigDecimal getShippingFee() {
        return new BigDecimal(10.11);
    }
}