/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.demo.controller;

import com.boxuegu.javaee.designpattern.demo.service.CustomerQuoteContext;
import com.boxuegu.javaee.designpattern.demo.service.IQuote;
import com.boxuegu.javaee.designpattern.demo.service.MVPCustomerQuote;
import com.boxuegu.javaee.designpattern.demo.service.NewCustomerQuote;
import com.boxuegu.javaee.designpattern.demo.service.OldCustomerQuote;
import com.boxuegu.javaee.designpattern.demo.service.PriceQuote;
import com.boxuegu.javaee.designpattern.demo.service.VipCustomerQuote;
import com.boxuegu.javaee.designpattern.strategy.sample2.QuoteManagerImprove;
import com.boxuegu.javaee.designpattern.strategy.sample3.QuoteContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/9 14:48
 */
@Controller
public class Price {
    BigDecimal iphonePrice = new BigDecimal(7100.00);
    @Autowired
    PriceQuote priceQuote;

    @RequestMapping(value = "/", produces = "text/plain;charset=UTF-8")
    public String index() {
        return "index";
    }


    @RequestMapping("/getPrice")
    @ResponseBody
    public String getPrice(String customerType) {
        CustomerQuoteContext context = new CustomerQuoteContext(customerType);
        return context.getPrice(iphonePrice);
        // return "7100.00";
        /*QuoteManager quoteManager = new QuoteManager();
        BigDecimal price = quoteManager.quote(new BigDecimal(7100.00), customerType);
        return price.toPlainString();*/
    }

    @RequestMapping("/getPrice1")
    @ResponseBody
    public String getPrice1(String customerType) {
        CustomerQuoteContext quoteContext;
        IQuote quote;
        //return priceQuote.quote(iphonePrice, customerType);
        if ("新客户".equalsIgnoreCase(customerType)) {
            quote = new NewCustomerQuote();
        } else if ("老客户".equalsIgnoreCase(customerType)) {
            quote = new OldCustomerQuote();
        } else if ("VIP客户".equalsIgnoreCase(customerType)) {
            quote = new VipCustomerQuote();
        } else if ("MVP客户".equalsIgnoreCase(customerType)) {
            quote = new MVPCustomerQuote();
        } else {
            quote = new NewCustomerQuote();
        }

        quoteContext = new CustomerQuoteContext(quote);
        return quoteContext.getPrice(iphonePrice);
        /*QuoteManager quoteManager = new QuoteManager();
        BigDecimal price = quoteManager.quote(new BigDecimal(7100.00), customerType);
        return price.toPlainString();*/
    }

    @RequestMapping("/getPrice2")
    @ResponseBody
    public String getPrice2(String customerType) {
        QuoteManagerImprove quoteManager = new QuoteManagerImprove();
        BigDecimal price = quoteManager.quote(new BigDecimal(7100.00), customerType);
        return price.toPlainString();
    }

    @RequestMapping("/getPrice3")
    @ResponseBody
    public String getPrice3(String customerType) {
        QuoteContext quoteContext = new QuoteContext(customerType);
        BigDecimal price = quoteContext.getPrice(new BigDecimal(7100.00));
        return price.toPlainString();
    }

}
