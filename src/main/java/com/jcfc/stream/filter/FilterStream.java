package com.jcfc.stream.filter;

import com.jcfc.lambda.entity.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 中间操作
 *
 *  一、筛选与切片：
 *      filter：     接收 Lambda，从流中排除某些元素
 *      limit：      截断流，使其元素不超过给定数量
 *                   注意：只要找到满足条件的数量后，后续的元素不会再迭代了
 *      skip(n)：    跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补
 *      distinct：   筛选去重，通过流所生成元素的 hashCode() 和 equals() 去除重复元素,自定义对象必须复写 hashCode() 和 equals() 方法
 */
public class FilterStream {

    private List<Employee> emps = Arrays.asList(
            new Employee("张三", 18, 3333.33),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 28, 6666.66),
            new Employee("赵六", 58, 9999.99),
            new Employee("田七", 8, 7777.77),
            new Employee("田七", 8, 7777.77),
            new Employee("田七", 8, 7777.77)
    );

    @Test
    public void test1() {
        //中间操作：不会执行任何操作
        Stream<Employee> stream = emps.stream()
                                    .filter((e) -> {
                                        System.out.println("过滤。");
                                        return e.getAge() > 35;
                                    });

        //终止操作：一次性执行全部中间操作内容，即“惰性求值”
        stream.forEach(System.out::println);
    }

    @Test
    public void test2() {
        emps.stream()
                .filter((e) -> {
                    //只要找到满足条件的数量后，后续的元素不会再迭代了
                    System.out.println("短路！");// && ||
                    return e.getSalary()>5000;
                })
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        emps.stream()
                .filter((e) -> e.getSalary()>5000)
                .skip(2)
                .distinct()
                .forEach(System.out::println);
    }

}
