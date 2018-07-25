package com.jcfc.time.oldapi;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 *  传统的时间操作是线程不安全的
 *      SimpleDateFormat非线程安全
 */
public class TestSimpleDateFormate {

    //3. 新Api解决线程安全问题
    @Test
    public void test3() throws ExecutionException, InterruptedException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");

        List<Future<LocalDate>> list = new ArrayList<>();

        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i=0; i<10; i++) {
            Future<LocalDate> future = pool.submit(() -> {
                return LocalDate.parse("20180520", dtf);
            });

            list.add(future);
        }

        for (Future<LocalDate> future : list) {
            System.out.println(future.get());
        }
    }

    //1. 传统操作有线程安全问题
    @Test
    public void test() throws ExecutionException, InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        List<Future<Date>> list = new ArrayList<>();

        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i=0; i<10; i++) {
            Future<Date> future = pool.submit(() -> {
                return sdf.parse("20180520");
            });

            list.add(future);
        }

        for (Future<Date> future : list) {
            System.out.println(future.get());
        }
    }

    //2. 传统线程安全问题的解决方法
    @Test
    public void test2() throws ExecutionException, InterruptedException {
        List<Future<Date>> list = new ArrayList<>();

        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i=0; i<10; i++) {
            Future<Date> future = pool.submit(() -> {
                return ThreadLocalDateFormate.parse("20180520");
            });

            list.add(future);
        }

        for (Future<Date> future : list) {
            System.out.println(future.get());
        }
    }

}
