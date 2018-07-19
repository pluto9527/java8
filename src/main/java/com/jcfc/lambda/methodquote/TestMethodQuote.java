package com.jcfc.lambda.methodquote;

import com.jcfc.lambda.entity.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、方法引用：若 Lambda 体中的内容有方法已经实现了，我们可以使用“方法引用”
 *              (可以理解为方法引用是 Lambda 表达式的另外一种表现形式)
 *
 *    主要有三种语法格式：
 *
 *    1.对象::实例方法名
 *
 *    2.类::静态方法名
 *
 *    3.类::实例方法名
 *
 *    注意：
 *      1).Lambda 体中调用方法的参数列表与返回值类型，要与函数式接口中的抽象方法的实现方法的函数列表和返回值类型 保持一致！
 *      2).若 Lambda 参数列表第一个参数是实例方法的调用者，二第二个参数是实例方法的参数时，可以使用ClassName::method
 *                  或者只有一个参数，第一个参数是实例方法的调用者，实例方法参数为空，也可以使用ClassName::method
 *
 * 二、构造器引用：
 *
 *      格式：
 *      ClassName::new
 *
 *      注意：
 *         需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致！
 *
 * 三、数组/集合 引用：
 *
 *      格式：
 *      Type::new
 *
 */


public class TestMethodQuote {

    //对象::实例方法名
    @Test
    public void test1() {
        PrintStream ps1 = System.out;
        Consumer<String> con1 = (x) -> ps1.println(x);

        PrintStream ps2 = System.out;
        Consumer<String> con2 = ps2::println;

        Consumer<String> con3 = System.out::println;

        con3.accept("对象::实例方法名");
    }
    @Test
    public void test2() {
        Employee employee = new Employee();
        Supplier<String> sup1 = () -> employee.getName();
        System.out.println(sup1.get());

        Supplier<Integer> sup2 = employee::getAge;
        System.out.println(sup2.get());

    }

    //类::静态方法名
    @Test
    public void test3() {
        Comparator<Integer> com1 = (x, y)-> Integer.compare(x,y);

        Comparator<Integer> com2 = Integer::compare;
    }

    //类::实例方法名
    @Test
    public void test4() {
        BiPredicate<String, String> bp1 = (x, y) -> x.equals(y);

        BiPredicate<String, String> bp2 = String::equals;
        System.out.println(bp2.test("a","b"));
    }

    //构造器引用
    @Test
    public void test5() {
        Supplier<Employee> sup1 = () -> new Employee();

        //注意构造器引用，方法参数列表也必须一致，因为supplier是无参的，所以调用对应的无参构造函数。
        Supplier<Employee> sup2 = Employee::new;
        System.out.println(sup2.get());
    }
    @Test
    public void test6() {
        Function<Integer, Employee> fun1 = (x) -> new Employee(x);

        //调用一个参数的构造函数
        Function<Integer, Employee> fun2 = Employee::new;
        System.out.println(fun2.apply(100));
    }

    //数组引用
    @Test
    public void test7() {
        Function<Integer, String[]> fun1 = (x) -> new String[x];
        String[] strs = fun1.apply(10);
        System.out.println(strs.length);

        Function<Integer, String[]> fun2 = String[]::new;
        System.out.println(fun2.apply(20).length);
    }

    //集合引用
    @Test
    public void test8() {
        Function<Integer, List> fun2 = ArrayList::new;
    }

}
