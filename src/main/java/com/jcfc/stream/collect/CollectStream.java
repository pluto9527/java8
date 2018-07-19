package com.jcfc.stream.collect;

import com.jcfc.lambda.entity.Employee;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 *  终止操作：
 *
 *  三、收集：
 *      collect：  将流转换为其他形式。
 *          接受一个Collector接口的实现(通过Collectors工具类的静态方法获取实现类)，用于给Stream中的元素做汇总的方法
 *
 */
public class CollectStream {

    private List<Employee> emps = Arrays.asList(
            new Employee("张三", 18, 3333.33, Employee.Status.FREE),
            new Employee("李四", 38, 5555.55, Employee.Status.BUSY),
            new Employee("王五", 28, 6666.66, Employee.Status.VOCATION),
            new Employee("赵六", 58, 9999.99, Employee.Status.FREE),
            new Employee("田七", 8, 7777.77, Employee.Status.BUSY)
    );

    //收集部分数据到集合中
    @Test
    public void test() {
        List<String> list = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        Set<String> set = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);

        HashSet<String> hashSet = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));//toCollection(Supplier<C>) 供给一个Collection子类
        hashSet.forEach(System.out::println);

        ConcurrentMap<String, Employee> concurrentMap = emps.stream()
                .collect(Collectors.toConcurrentMap(Employee::getName, (e)->e));
    }

    //统计
    @Test
    public void test2() {
        //总数
        Long count = emps.stream()
                .collect(Collectors.counting());
        System.out.println(count);

        //平均值
        Double avg = emps.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);

        //总和
        Double sum = emps.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);

        //最大值
        Optional<Employee> maxop = emps.stream()
                //没有提取，所以获取的是员工信息，不单是薪水
                .collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(maxop.get());

        //最小值
        Optional<Double> minop = emps.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.out.println(minop.get());
    }

    //一次性获取所有统计结果summarizing
    @Test
    public void test6() {
        DoubleSummaryStatistics dss = emps.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getSum());
        System.out.println(dss.getAverage());
        System.out.println(dss.getMax());
    }

    //分组
    @Test
    public void test3() {
        //按状态分组
        Map<Employee.Status, List<Employee>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
    }

    //多级分组
    @Test
    public void test4() {
        //一级状态分，二级年龄段分
        Map<Employee.Status, Map<String, List<Employee>>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if (e.getAge() <= 25) {
                        return "青年";
                    } else if (e.getAge() <= 50) {
                        return "中年";
                    } else {
                        return "老年";
                    }
                })));
    }

    //分区
    @Test
    public void test5() {
        Map<Boolean, List<Employee>> map = emps.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 5000));
        System.out.println(map);
        map.forEach((k,v) -> System.out.println(k+":"+v));
    }

    //拼接
    @Test
    public void test7() {
        String str = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",", "-prefix-", "-suffix-"));
        System.out.println(str);
    }

}
