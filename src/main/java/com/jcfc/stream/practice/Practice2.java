package com.jcfc.stream.practice;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Practice2 {

    List<Transaction> trans = null;

    @Before
    public void before() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        trans = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    //1.找出2011年发生的所有交易，并按交易额排序
    @Test
    public void test1() {
        trans.stream()
                .filter((t) -> t.getYear() == 2011)
                .sorted((t1, t2) -> Integer.compare(t1.getValue(),t2.getValue()))
                .forEach(System.out::println);
    }

    //2.交易员都在哪些不同的城市工作过
    @Test
    public void test2() {
        trans.stream()
                .map((t) -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    //3.查找所有来自剑桥的交易员，并按姓名排序
    @Test
    public void test3() {
        trans.stream()
                .filter((t) -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .sorted((t1,t2) -> t1.getName().compareTo(t2.getName()))
                .distinct()
                .forEach(System.out::println);
    }

    //4.返回所有交易员的姓名字符串，并按字母顺序排序
    @Test
    public void test4() {
        trans.stream()
                .map((t) -> t.getTrader().getName())
                .sorted()
                .forEach(System.out::println);

        String str = trans.stream()
                .map((t) -> t.getTrader().getName())
                .sorted()
                .reduce("", String::concat);//静态方法，拼接字符串
        System.out.println(str);
    }

    //5.有没有交易员是在米兰工作的
    @Test
    public void test5() {
        boolean b = trans.stream()
                .anyMatch((t) -> t.getTrader().getCity().equals("Milan"));
        System.out.println(b);
    }

    //6.打印生活在剑桥的交易员的所有交易额
    @Test
    public void test6() {
        Optional<Integer> sum = trans.stream()
                .filter((t) -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(Integer::sum);
        System.out.println(sum.get());
    }

    //7.所有交易中，最高的交易额是多少
    @Test
    public void test7() {
        Optional<Integer> max = trans.stream()
                .map(Transaction::getValue)
                .max(Integer::compare);
        System.out.println(max.get());
    }

    //8.找到交易额最小的交易
    @Test
    public void test8() {
        Optional<Transaction> min = trans.stream()
                .min((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()));
        System.out.println(min.get());
    }

}
