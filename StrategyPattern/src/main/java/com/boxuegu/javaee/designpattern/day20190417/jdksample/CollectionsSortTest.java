/*
 * Copyright (c) 博学谷 http://www.boxuegu.com
 *
 */

package com.boxuegu.javaee.designpattern.day20190417.jdksample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Jam Fang  https://www.jianshu.com/u/0977ede560d4
 * @version 创建时间：2019/4/10 12:59
 */
public class CollectionsSortTest {
    public static void main(String[] args) {
        Student stu[] = {
                new Student("张三", 23),
                new Student("李四", 26)
                , new Student("王五", 22)};
        System.out.println(Arrays.toString(stu));
        for (Student student:stu ) {
            System.out.println(student.getName()+":"+student.getAge());
        }
        Arrays.sort(stu, new SortComparator());

        List<Student> list = new ArrayList<>(3);
        list.add(new Student("zhangsan", 31));
        list.add(new Student("lisi", 30));
        list.add(new Student("wangwu", 35));
        Collections.sort(list, new SortComparator());
        for (Student student:list ) {
            System.out.println(student.getName()+":"+student.getAge());
        }
        System.out.println(list);
    }
}
class Student {
    String name;
    int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class SortComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return
                ((Student) o1).getAge() - ((Student) o2).getAge();
    }
}
