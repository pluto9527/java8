package com.jcfc.stream.match;

import com.jcfc.lambda.entity.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 *  终止操作：
 *
 *  一、查找与匹配：
 *      allMatch:   检查是否匹配所有元素
 *      anyMath:    检查是否至少匹配一个元素
 *      noneMatch:  检查是否没有匹配所有元素
 *      findFirst:  返回第一个元素
 *      findAny:    返回当前流中的任意元素
 *      count:  返回流中元素总个数
 *      max:    返回流中最大值
 *      min:    返回流中最小值
 *
 */
public class FindAndMatch {

    private List<Employee> emps = Arrays.asList(
            new Employee("张三", 18, 3333.33, Employee.Status.FREE),
            new Employee("李四", 38, 5555.55, Employee.Status.BUSY),
            new Employee("王五", 28, 6666.66, Employee.Status.VOCATION),
            new Employee("赵六", 58, 9999.99, Employee.Status.FREE),
            new Employee("田七", 8, 7777.77, Employee.Status.BUSY)
    );

    @Test
    public void test1() {
        boolean b1 = emps.stream()
                .allMatch((e) -> e.getStatus().equals(Employee.Status.FREE));
        System.out.println(b1);

        boolean b2 = emps.stream()
                .anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b2);

        boolean b3 = emps.stream()
                .noneMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b3);

        Optional<Employee> op1 = emps.stream()
                .sorted((e1, e2) -> -Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
        System.out.println(op1.get());

        Optional<Employee> op2 = emps.parallelStream()
                .filter((e) -> e.getStatus().equals(Employee.Status.FREE))
                .findAny();
        System.out.println(op2.get());

    }

    @Test
    public void test2() {
        long count = emps.stream()
                .count();
        System.out.println(count);

        Optional<Employee> op1 = emps.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(op1.get());

        Optional<Double> op2 = emps.stream()
                .map(Employee::getSalary)//先提取
                .min(Double::compare);
        System.out.println(op2.get());
    }

}
