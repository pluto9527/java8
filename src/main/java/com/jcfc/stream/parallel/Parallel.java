package com.jcfc.stream.parallel;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * java8并行流:
 *  （底层实现是 Fork/Join 框架）
 *
 *      切换并行流:
 *          parallel()
 *          list.parallelStream()
 *      切换穿行流:
 *          sequential()
 *
 */
public class Parallel {

    @Test
    public void test() {
        Instant start = Instant.now();

        //LongStream.rangeClosed生成在开始和结束之间所有连续的数，closed是包含结束，不带是不包含
        long sum = LongStream.rangeClosed(0, 100000000L)
                .parallel()
                .reduce(0, Long::sum);

        Instant end = Instant.now();

        System.out.println("耗费时间："+ Duration.between(start, end).toMillis());

    }

}
