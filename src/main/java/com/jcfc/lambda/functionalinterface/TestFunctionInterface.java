package com.jcfc.lambda.functionalinterface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8 内置的四大核心函数式接口
 *
 * Consumer<T> : 消费型接口  (有接受无返回)
 *      void accept(T t);
 *
 * Supplier<T> : 供给型接口  (无接收有返回)
 *      T get();
 *
 * Function<T, R> : 函数式接口   (有接受有返回)
 *      R apply(T t);
 *
 * Predicate<T> : 断言型接口 (判断)
 *      boolean test(T t);
 *
 */
public class TestFunctionInterface {

    /**
     * Consumer<T> : 消费型接口
     */
    @Test
    public void test1() {
        consume(10000, (x) -> System.out.println("消费了："+x+"元."));
    }
    private void consume(double num, Consumer<Double> consumer) {
        consumer.accept(num);
    }

    /**
     * Supplier<T> : 供给型接口
     * 产生指定个数的整数，并放入集合中
     */
    @Test
    public void test2() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        System.out.println(numList);
    }
    private List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<num; i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }

    /**
     * Function<T, R> : 函数式接口
     * 处理字符串
     */
    @Test
    public void test3() {
        String str = strHandler("\t\t\t 我是你爹！ ", (t) -> t.trim());
        System.out.println(str);
    }
    private String strHandler(String str, Function<String, String> function) {
        return function.apply(str);
    }


    /**
     * Predicate<T> : 断言型接口
     * 将满足条件的字符串，放入集合中
     */
    @Test
    public void test4() {
        List<String> list = Arrays.asList("Hello", "Lambda", "clearun7");
        List<String> stringList = filterStr(list, (s) -> s.length() > 7);
        System.out.println(stringList);
    }
    private List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> strList = new ArrayList<>();
        for (String str : list) {
            if (pre.test(str)) {
                strList.add(str);
            }
        }
        return strList;
    }

}
