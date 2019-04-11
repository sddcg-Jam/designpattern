/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.demo.service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/10 11:30
 */
public interface IQuote {
    public static Map<String, IQuote> map = new ConcurrentHashMap<>();

    public String getCustomerType();

    public String quote(BigDecimal originalPrice);

    @PostConstruct
    default public void init() {
        map.put(this.getCustomerType(), this);
    }
}
