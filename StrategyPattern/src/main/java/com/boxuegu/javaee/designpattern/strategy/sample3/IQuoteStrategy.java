/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.strategy.sample3;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

/**
 * 报价策略接口
 *
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/9 11:27
 */
public interface IQuoteStrategy {
    /**
     *  获取折后价的价格
     * @param originalPrice
     * @return
     */
    public BigDecimal quote(BigDecimal originalPrice);
    //@PostConstruct

}
