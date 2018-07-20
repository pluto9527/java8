package com.jcfc.stream.practice;

import com.jcfc.lambda.entity.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 怎样用map 和 reduce 方法数一数流中有多少个Employee？
 */
public class Practice1 {

    private List<Employee> emps = Arrays.asList(
            new Employee("张三", 18, 3333.33),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 28, 6666.66),
            new Employee("赵六", 58, 9999.99),
            new Employee("田七", 8, 7777.77)
    );

    @Test
    public void test() {
        //把每次对象用1代替来统计，相当于count(1)；
        Optional<Integer> sum = emps.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);
        System.out.println(sum.get());
    }

}
