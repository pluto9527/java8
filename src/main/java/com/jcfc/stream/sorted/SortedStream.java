package com.jcfc.stream.sorted;

import com.jcfc.lambda.entity.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 *  三、排序：
 *      sorted()——自然排序(Comparable)，compareTo方法，（Integer,String等都实现了Comparable接口）
 *      sorted(Comparator com)——定制排序(Comparator)
 *
 */
public class SortedStream {

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
    public void test() {
        List<String> list = Arrays.asList("ccc", "bbb", "ddd", "aaa", "eee");
        list.stream()
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    public void test2() {
        emps.stream()
                .sorted((e1, e2) -> {
                    if (e1.getAge().equals(e2.getAge())) {
                        return e1.getName().compareTo(e2.getName());
                    } else {
                        return -e1.getAge().compareTo(e2.getAge());
                    }
                })
                .forEach(System.out::println);
    }

}
