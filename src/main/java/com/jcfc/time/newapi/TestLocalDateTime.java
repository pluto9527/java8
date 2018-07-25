package com.jcfc.time.newapi;

import org.junit.Test;

import java.time.*;

/**
 *  1. LocalDate    LocalTime   LocalDateTime
 *
 *  2. Instant ： 时间戳（以Unix元年：1970年1月1日 00：00：00到某个时间之间的毫秒值）
 *
 *  3. Duration ：计算两个“时间”之间的间隔（Instant, LocalDateTime, LocalTime）
 *     Period   ：计算两个“日期”之间的间隔（LocalDate）
 *
 */
public class TestLocalDateTime {

    //1. LocalDate    LocalTime   LocalDateTime
    @Test
    public void test1() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = LocalDateTime.of(2015, 10, 10, 18, 21, 22);
        System.out.println(ldt2);

        //增加两年，每次都会创建新对象
        LocalDateTime ldt3 = ldt.plusYears(2);
        System.out.println(ldt3);

        //减少两个月
        LocalDateTime ldt4 = ldt.minusMonths(2);
        System.out.println(ldt4);

        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getHour());
        System.out.println(ldt.getMinute());
        System.out.println(ldt.getSecond());
    }

    //2. Instant ： 时间戳（以Unix元年：1970年1月1日 00：00：00到某个时间之间的毫秒值）
    @Test
    public void test2() {
        Instant ins1 = Instant.now();
        System.out.println(ins1);

        //偏移8个时区
        OffsetDateTime odt = ins1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);

        //时间戳转换为毫秒值
        System.out.println(ins1.toEpochMilli());

        //在1970:00:00基础上增加多少毫秒
        Instant ins2 = Instant.ofEpochSecond(60);
        System.out.println(ins2);
    }

    //3. Duration ：计算两个“时间”之间的间隔（Instant, LocalDateTime, LocalTime）
    @Test
    public void test3() {
        Instant ins1 = Instant.now();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        Instant ins2 = Instant.now();

        Duration duration = Duration.between(ins1, ins2);
        System.out.println(duration.toMillis());

        System.out.println("-----");

        LocalTime lt1 = LocalTime.now();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        LocalTime lt2 = LocalTime.now();

        System.out.println(Duration.between(lt1, lt2).toMillis());
    }

    //4. Period   ：计算两个“日期”之间的间隔（LocalDate）
    @Test
    public void test4() {
        LocalDate ld1 = LocalDate.of(2015, 1, 1);
        LocalDate ld2 = LocalDate.now();

        Period period = Period.between(ld1, ld2);
        System.out.println(period);

        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }

}
