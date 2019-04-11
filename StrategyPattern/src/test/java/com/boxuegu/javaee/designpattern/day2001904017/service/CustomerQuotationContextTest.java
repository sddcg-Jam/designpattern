/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.day2001904017.service;

import com.boxuegu.javaee.designpattern.MyApplication;
import com.boxuegu.javaee.designpattern.day2001904017.util.Constant;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/11 10:56
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class CustomerQuotationContextTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getPrice() {
        String customerType = Constant.NEW;
        BigDecimal originalPrice = new BigDecimal(7100.00);
        CustomerQuotationContext customerQuotationContext = new CustomerQuotationContext(customerType);
        BigDecimal myPrice = customerQuotationContext.getPrice(originalPrice);
        String price = myPrice.toPlainString();
        assertEquals("期望为正常价格", originalPrice.toPlainString(), price);

        customerType = Constant.OLD;
        customerQuotationContext = new CustomerQuotationContext(customerType);
        myPrice = customerQuotationContext.getPrice(originalPrice);
        assertEquals("期望为正常价格", originalPrice.multiply(new BigDecimal(0.9))
                .setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString(), myPrice.toPlainString());

        customerType = Constant.VIP;
        customerQuotationContext = new CustomerQuotationContext(customerType);
        myPrice = customerQuotationContext.getPrice(originalPrice);
        assertEquals("期望为正常价格", originalPrice.multiply(new BigDecimal(0.8))
                .setScale(2, BigDecimal.ROUND_HALF_UP), myPrice);

        customerType = Constant.MVP;
        customerQuotationContext = new CustomerQuotationContext(customerType);
        myPrice = customerQuotationContext.getPrice(originalPrice);
        assertEquals("期望为正常价格", originalPrice.multiply(new BigDecimal(0.7))
                .setScale(2, BigDecimal.ROUND_HALF_UP), myPrice);
    }
}