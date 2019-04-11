/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.day20190417.service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/11 16:10
 */
public interface ICustomerQuotation {
    public static Map<String, ICustomerQuotation> map = new ConcurrentHashMap();

    public BigDecimal getQuotation(BigDecimal originalPrice);

    public BigDecimal getShippingFee();

    public String getCustomerType();

    @PostConstruct
    default public void init() {
        map.put(getCustomerType(), this);
    }
}
