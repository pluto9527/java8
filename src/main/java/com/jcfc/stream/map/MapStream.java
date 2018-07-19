package com.jcfc.stream.map;

import com.jcfc.lambda.entity.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *  二、映射：
 *      map:    接收Lambda，将元素转换成其它形式或提取信息。接受一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
 *      flatMap:接收一个函数作为参数，将流中的每个值都转换成另一个流，然后把所有流连接成一个流
 *
 */
public class MapStream {

    private List<Employee> emps = Arrays.asList(
            new Employee("张三", 18, 3333.33),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 28, 6666.66),
            new Employee("赵六", 58, 9999.99),
            new Employee("田七", 8, 7777.77)
    );

    List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");

    @Test
    public void test() {
        list.stream()
//                .map((str) -> str.toUpperCase())
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @Test
    public void test2() {
        emps.stream()
//                .map((e) -> e.getName())
                .map(Employee::getName)//只有一个参数，第一个参数是实例方法的调用者，实例方法参数为空，也可以使用ClassName::method
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        Stream<Stream<Character>> stream = list.stream()
                .map(MapStream::filterCharacter);

        stream.forEach((sm) -> {
            sm.forEach(System.out::println);
        });

    }
    //把集合中每一个字符串转换成一个字符流
    private static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    @Test
    public void test4() {
        Stream<Character> stream = list.stream()
                .flatMap(MapStream::filterCharacter);
        stream.forEach(System.out::println);
    }

}
