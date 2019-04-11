/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.strategy.samplexichuan;

/**
 * 中策：杨怀、高沛是蜀中名将，手下有精锐部队，而且据守关头，
 * 我们可以装作要回荆州，引他们轻骑来见，可就此将其擒杀，而后进兵成都，此为中计。
 *
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/9 11:50
 */
public class MiddleOccupationStrategy implements IOccupationStrategy {
    @Override
    public void occupationWestOfSiChuan(String msg) {
        System.out.println("杨怀、高沛是蜀中名将，手下有精锐部队，而且据守关头，我们可以装作要回荆州，引他们轻骑来见，可就此将其擒杀，而后进兵成都，此为中计。");
    }
}
