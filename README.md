# 一个真实需求
程序员小林
某电商网站
显示商品价格 iphone 价格7100元

## v1
需要根据客户类型，进行不同的折扣，新客户不打折扣，针对老客户打9折。
最简单的 实现代码 版本1
```
if ("新客户".equals(customType)) {
    System.out.println("抱歉！新客户没有折扣！");
    return originalPrice;
}else if ("老客户".equals(customType)) {
    System.out.println("恭喜你！老客户打9折！");
    originalPrice = originalPrice.multiply(new BigDecimal(0.9)).setScale(2,BigDecimal.ROUND_HALF_UP);
    return originalPrice;
}
```

## v2 
现在需求变更了，增加了针对VIP客户打8折
```
if ("新客户".equals(customType)) {
    System.out.println("抱歉！新客户没有折扣！");
    return originalPrice;
}else if ("老客户".equals(customType)) {
    System.out.println("恭喜你！老客户打9折！");
    originalPrice = originalPrice.multiply(new BigDecimal(0.9)).setScale(2,BigDecimal.ROUND_HALF_UP);
    return originalPrice;
}else if("VIP客户".equals(customType)){
    System.out.println("恭喜你！VIP客户打8折！");
    originalPrice = originalPrice.multiply(new BigDecimal(0.8)).setScale(2,BigDecimal.ROUND_HALF_UP);
    return originalPrice;
}
```

## V3 重构
寻找代码问题
###第一次
提取成方法
###第二次
提取接口，重构实现类
###第三次
提取context
这就是策略模式

# 引入策略模式
## 定义
定义一系列的算法，把它们一个个封装起来，并且使它们可相互替换。
## 类图
![类图](./类图.png) 

## 使用场景
1.多个类只有在算法或行为上稍有不同的场景。
2.算法需要自由切换的场景。
3.需要屏蔽算法规则的场景。  


## 优点：
1.算法可以自由切换。 
2.避免使用多重条件判断。 
3.扩展性良好
(1) 策略模式提供了对“开闭原则”的完美支持，用户可以在不修改原有系统的基础上选择算法或行为，也可以灵活地增加新的算法或行为。
(2) 算法的使用就和算法本身分开，符合“单一职责原则”，决定使用哪一种算法的逻辑和该算法本身独立演化；
(3) 策略模式提供了一种算法的复用机制，由于将算法单独提取出来封装在策略类中，因此不同的环境类可以方便地复用这些策略类。

4. 缺点
(1) 客户端必须知道所有的策略类，并自行决定使用哪一个策略类。这就意味着客户端必须理解这些算法的区别，以便适时选择恰当的算法。换言之，策略模式只适用于客户端知道所有的算法或行为的情况。
(2) 策略模式将造成系统产生很多具体策略类，任何细小的变化都将导致系统要增加一个新的具体策略类。
(3) 无法同时在客户端使用多个策略类，也就是说，在使用策略模式时，客户端每次只能使用一个策略类，不支持使用一个策略类完成部分功能后再使用另一个策略类来完成剩余功能的情况。

# 其他应用
## 应用案例 
1、诸葛亮的锦囊妙计，每一个锦囊就是一个策略。
三国刘备取西川时，谋士庞统给的上、中、下三个计策：
　　上策：挑选精兵，昼夜兼行直接偷袭成都，可以一举而定，此为上计计也。
　　中策：杨怀、高沛是蜀中名将，手下有精锐部队，而且据守关头，我们可以装作要回荆州，引他们轻骑来见，可就此将其擒杀，而后进兵成都，此为中计。
　　下策：退还白帝，连引荆州，慢慢进图益州，此为下计。
这三个计策都是取西川的计策，也就是攻取西川这个问题的具体的策略算法，刘备可以采用上策，可以采用中策，当然也可以采用下策，由此可见策略模式的各种具体的策略算法都是平等的，可以相互替换。
那谁来选择具体采用哪种计策（算法）？在这个故事中当然是刘备选择了，也就是外部的客户端选择使用某个具体的算法，然后把该算法（计策）设置到上下文当中；
还有一种情况就是客户端不选择具体的算法，把这个事交给上下文，这相当于刘备说我不管有哪些攻取西川的计策，我只要结果（成功的拿下西川），具体怎么攻占（有哪些计策，怎么选择）由参谋部来决定（上下文）。

2、旅行的出游方式，选择骑自行车、坐汽车，每一种旅行方式都是一个策略。 

# 策略模式在JDK中的应用
- ThreadPoolExecutor
RejectedExecutionHandler 是一个策略接口，用在当线程池中没有多余的线程来执行任务，并且保存任务的多列也满了（指的是有界队列），对仍在提交给线程池的任务的处理策略。
![](threadpoolExecutor.png)

- JAVA AWT 中的 LayoutManager

![类图](http://wiki.jikexueyuan.com/project/design-pattern-behavior/images/1343812299_2772.jpg)

- Collections排序中的应用 Comparator 
我们如果需要控制某个类的次序，而该类本身不支持排序（即没有实现Comparable接口）；那么可以建立一个该类的比较器来排序，这个比较器只需要实现Comparator接口即可。,通过实现Comparator类来新建一个比较器，然后通过该比较器来对类进行排序。Comparator 接口其实就是一种策略模式的实践
事例代码：
抽象策略类 Comparator
```
public interface Comparator<T> {
    int compare(T o1, T o2);
    boolean equals(Object obj);
 }
```
具体策略类 SortComparator
```
public class SortComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student student1 = (Student) o1;
        Student student2 = (Student) o2;
        return student1.getAge() - student2.getAge();
    }
}
```
策略模式上下文 Collections
```
public class Client {

    public static void main(String[] args) {

        Student stu[] = {
                new Student("张三" ,23),
                new Student("李四" ,26)
                , new Student("王五" ,22)};
        Arrays. sort(stu,new SortComparator());
        System.out.println(Arrays.toString(stu));

        List<Student> list = new ArrayList<>(3);
        list.add( new Student("zhangsan" ,31));
        list.add( new Student("lisi" ,30));
        list.add( new Student("wangwu" ,35));
        Collections.sort(list,new SortComparator());
        System.out.println(list);

    }

}
```
数据流
```
countRunAndMakeAscending:355, TimSort (java.util)
sort:220, TimSort (java.util)
sort:1438, Arrays (java.util)
main:20, Client (designpattern.strategy.compare)
```
调用Collections.sort方法之后走的是Arrays.sort()方法，然后TimSort类中countRunAndMakeAscending方法中调用具体比较器的算法实现进行比较，完成排序。这是大家比较常用的对象排序工具类。

# 电商案例的再重构
## V4
商场营销部新推出了一个客户类型--MVP用户（Most Valuable Person），可以享受折扣7折优惠，那该怎么办呢？
增加新的实现类

## 继续重构
通过spring继续重构
@PostConstruct
