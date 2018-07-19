package com.jcfc.lambda.practice;

import org.junit.Test;

/**
 * 对两个Long型运算
 *
 * 由于我们每次都要自己新建接口，java8给我们内置了一些函数式接口
 */
public class Practice {

    @Test
    public void test() {
        operation(100L, 200L, (x, y) -> x+y);
    }

    private void operation(Long l1, Long l2, MyFunction<Long, Long> myFunction) {
        System.out.println(myFunction.getValue(l1, l2));
    }


}
