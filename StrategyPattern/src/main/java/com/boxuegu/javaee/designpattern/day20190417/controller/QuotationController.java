/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.day20190417.controller;

import com.boxuegu.javaee.designpattern.day20190417.service.ICustomerQuotation;
import com.boxuegu.javaee.designpattern.day20190417.service.NewCustomerQuotation;
import com.boxuegu.javaee.designpattern.day20190417.service.OldCustomerQuotation;
import com.boxuegu.javaee.designpattern.day20190417.service.CustomerQuotationContext;
import com.boxuegu.javaee.designpattern.day20190417.service.VIPCustomerQuotation;
import com.boxuegu.javaee.designpattern.day20190417.util.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/11 15:49
 */
@Controller
public class QuotationController {
    public static final BigDecimal originalPrice = new BigDecimal(7100.00).setScale(2, BigDecimal.ROUND_HALF_UP);

    @RequestMapping("/getMyQuotation")
    @ResponseBody
    public String getPrice(String customerType) {
        BigDecimal myPrice = originalPrice;
//        ICustomerQuotation quotation;
//        if (Constant.NEW.equalsIgnoreCase(customerType)) {
//            quotation = new NewCustomerQuotation();
//        } else if (Constant.OLD.equalsIgnoreCase(customerType)) {
//            quotation = new OldCustomerQuotation();
//        } else if (Constant.VIP.equalsIgnoreCase(customerType)) {
//            quotation = new VIPCustomerQuotation();
//        } else {
//            quotation = new NewCustomerQuotation();
//        }
        CustomerQuotationContext customerQuotationContext = new CustomerQuotationContext(customerType);
        return customerQuotationContext.getPrice(originalPrice);
    }



    public static void main(String[] args) {
        QuotationController quotation = new QuotationController();

        String price = quotation.getPrice(Constant.NEW);
        System.out.println(Constant.NEW + "对应的价格为：" + price);

        price = quotation.getPrice(Constant.OLD);
        System.out.println(Constant.OLD + "对应的价格为：" + price);


        price = quotation.getPrice(Constant.MVP);
        System.out.println(Constant.MVP + "对应的价格为：" + price);
    }

}
