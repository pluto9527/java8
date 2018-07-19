package com.jcfc.stream.create;

import com.jcfc.lambda.entity.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一、Stream 的三个操作步骤
 *
 * 1. 创建流 Stream
 *      1). 通过 Collection 系列集合提供的 stream() 或 parallelStream() 方法获取
 *      2). 通过 Arrays 中的静态方法 stream() 获取数组流
 *      3). 通过 Stream 类中的静态方法 of(T... t)获取
 *      4). 创建无限流
 *          (1). 迭代
 *                  第一个参数是种子，指定起始位置，并定义泛型类型
 *                  第二个参数是UnaryOperator<T> extends Function<T, T>， 一元运算函数式接口，接收与返回的类型一致
 *          (2). 生成
 *                  参数是Supplier<T>，无限生成
 *
 * 2. 中间操作
 *
 * 3. 终止操作(终端操作)
 */
public class CreateStream {

    /**
     * 创建流 Stream
     */
    @Test
    public void test() {
        //1. 通过 Collection 系列集合提供的 stream() 或 parallelStream() 方法获取
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2. 通过 Arrays 中的静态方法 stream() 获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);

        //3. 通过 Stream 类中的静态方法 of(T... t)获取
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        //4. 创建无限流
        /*  1).迭代
                第一个参数是种子，指定起始位置，并定义泛型类型
                第二个参数是UnaryOperator<T> extends Function<T, T>， 一元运算函数式接口，接收与返回的类型一致
         */
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(5).forEach(System.out::println);

        //   2).生成  参数是Supplier<T>，无限生成
        Stream.generate(() -> Math.random())
                .limit(5)
                .forEach(System.out::println);

    }

}
