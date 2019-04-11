/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.day2001904017.service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/10 19:22
 */
public interface ICustomerQuotation {
    public static Map<String, ICustomerQuotation> map = new ConcurrentHashMap();

    public BigDecimal quotation(BigDecimal originalPrice);

    public String getCustomerType();

    @PostConstruct
    default public void init() {
        map.put(this.getCustomerType(), this);

    }

}
