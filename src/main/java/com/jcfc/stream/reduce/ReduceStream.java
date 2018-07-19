package com.jcfc.stream.reduce;

import com.jcfc.lambda.entity.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 *
 *  终止操作：
 *
 *  二、归约(reduce)：
 *      reduce(T identity, BinaryOperator<T> accumulator)
 *          第一个参数identity为初始元素，作为二元运算的第一个参数
 *          第二个参数BinaryOperator为二元运算，(x, y) -> x+y
 *      reduce(BinaryOperator<T> accumulator)
 *          流中前两个元素作为二元运算的初始参数
 *
 *      可以将流中元素反复结合起来（二元运算），得到一个值
 *
 *
 */
public class ReduceStream {

    private List<Employee> emps = Arrays.asList(
            new Employee("张三", 18, 3333.33, Employee.Status.FREE),
            new Employee("李四", 38, 5555.55, Employee.Status.BUSY),
            new Employee("王五", 28, 6666.66, Employee.Status.VOCATION),
            new Employee("赵六", 58, 9999.99, Employee.Status.FREE),
            new Employee("田七", 8, 7777.77, Employee.Status.BUSY)
    );

    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //有初始值不可能为null，所以返回Integer
        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(sum);
    }

    @Test
    public void test2() {
        //由于emps或者salary都有可能为空，防止空指针，返回Optional容器
        Optional<Double> op = emps.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);//二元运算static double sum(double a, double b)
        System.out.println(op.get());
    }

}
