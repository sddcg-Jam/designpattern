/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.day2001904017.controller;

import com.boxuegu.javaee.designpattern.day2001904017.service.CustomerQuotationContext;
import com.boxuegu.javaee.designpattern.day2001904017.util.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/10 17:41
 */
@Controller
public class QuotationController {
    private BigDecimal originalPrice = new BigDecimal(7100.00);

    @RequestMapping("/getMyQuotation")
    @ResponseBody
    public String getMyQuotation(String customerType) {
        CustomerQuotationContext customerQuotationContext = new CustomerQuotationContext(customerType);
        if (customerQuotationContext == null) {
            customerQuotationContext = new CustomerQuotationContext(Constant.NEW);
        }
        BigDecimal myPrice = customerQuotationContext.getPrice(originalPrice);
        return myPrice.toPlainString();
    }
}
