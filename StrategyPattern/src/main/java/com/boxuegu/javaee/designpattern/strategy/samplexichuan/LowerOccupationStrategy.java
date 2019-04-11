/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.strategy.samplexichuan;

/**
 * 退还白帝，连引荆州，慢慢进图益州，此为下计。
 *
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/9 11:51
 */
public class LowerOccupationStrategy implements IOccupationStrategy {
    @Override
    public void occupationWestOfSiChuan(String msg) {
        System.out.println("退还白帝，连引荆州，慢慢进图益州，此为下计。");
    }
}
