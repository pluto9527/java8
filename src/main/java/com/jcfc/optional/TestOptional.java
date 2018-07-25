package com.jcfc.optional;

import com.jcfc.lambda.entity.Employee;
import org.junit.Test;

import java.util.Optional;

/**
 *  Optional 容器类的常用方法：
 *  Optional.of(T t) ：创建一个Optional实例
 *  Optional.empty() ：创建一个空的Optional实例
 *  Optional.ofNullable(T t) ：若t不为null，创建Optional实例，否则创建空实例（null）
 *
 *  isPresent() ：判断容器是否包含值
 *  orElse(T t) ：如果调用的容器对象包含值，则返回该值，否则返回t
 *  orElseGet(Supplier s) ：如果调用对象包含值，返回该值，否则返回s 获取的值
 *  map(Function f) ：如果有值对其处理，并返回处理后的Optional，否则返回Optional.empty()
 *  flatMap(Function mapper) ：与map类似，要求function的返回值必须是Optional
 *
 *
 */
public class TestOptional {

    @Test
    public void test() {
        Optional<Employee> op = Optional.ofNullable(null);

        if (op.isPresent()) {
            System.out.println(op.get());
        }

        Employee employee = op.orElse(new Employee("张三", 18, 888.88, Employee.Status.FREE));
        System.out.println(employee);

        Employee employee1 = op.orElseGet(() -> new Employee());
        System.out.println(employee1);
    }

    @Test
    public void test2() {
        Optional<Employee> op = Optional.ofNullable(new Employee("张三", 18, 888.88, Employee.Status.FREE));

        Optional<String> str = op.map((Employee::getName));
        System.out.println(str.get());

        Optional<String> str2 = op.flatMap((e) -> Optional.of(e.getName()));
        System.out.println(str2.get());
    }

}
