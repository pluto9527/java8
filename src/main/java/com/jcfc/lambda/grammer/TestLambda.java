package com.jcfc.lambda.grammer;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 一、Lambda 表达式的基础语法：Java8中引入了一个新的操作符 "->" 该操作符称为箭头操作符或 lambda 操作符
 *                          箭头操作符将 Lambda 表达式拆成两部分：
 * 左侧：Lambda 表达式的参数列表
 * 右侧：Lambda 表达式中所需执行的功能，即 Lambda 体
 *
 * 语法格式一：无参数，无返回值
 *      () -> System.out.println("Hello！");
 *
 * 语法格式二：有一个参数，并且无返回值
 *      (x) -> System.out.println(x);
 *
 * 语法格式三：若只有一个参数，小括号可以省略不写
 *      x -> System.out.println(x);
 *
 * 语法格式四：有两个以上的参数，有返回值，并且 Lambda 体中有多条语句(要加大括号)
 *      Comparator<Integer> com = (x, y) -> {
 *           System.out.println("函数式接口");
 *           return Integer.compare(x, y);
 *      };
 *
 * 语法格式五：若 Lambda 体中只有一条语句，return 和 大括号 都可以省略不写
 *      Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
 *
 * 语法格式六：Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出数据类型，即“类型推断”
 *      (Integer x, Integer y) -> Integer.compare(x, y);
 *
 *
 * 二、Lambda 表达式需要“函数式接口”的支持
 *  函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。
 *              可以使用注解 @FunctionalInterface 修饰，该注解可以检查是否是函数式接口。
 *
 */
public class TestLambda {

    /**
     * 对一个数进行运算
     */
    @Test
    public void test() {
        Integer a = operation(100, (x) -> x * x);
        System.out.println(a);
    }

    private Integer operation(Integer num, MyFunction<Integer> myFunction) {
        return myFunction.getValue(num);
    }

    @Test
    public void test1() {
        Runnable runnable = () -> System.out.println("Hello！");
        runnable.run();
    }

    @Test
    public void test2() {
        Consumer consumer = (x) -> System.out.println(x);
        consumer.accept(10);
    }

    @Test
    public void test3() {
        Comparator<Integer> com = (Integer x, Integer y) -> Integer.compare(x, y);
        com.compare(1,3);
    }

}
