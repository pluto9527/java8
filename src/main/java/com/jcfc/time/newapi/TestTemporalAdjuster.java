package com.jcfc.time.newapi;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 *  一、TemporalAdjuster ：时间校正器
 *     TemporalAdjusters ：工具类，用来操作TemporalAdjuster
 *
 *  二、DateTimeFormatter ：格式化时间/日期
 *
 *  三、ZonedDate、ZonedTime、ZonedDateTime ：时区
 *
 */
public class TestTemporalAdjuster {

    //1. TemporalAdjuster ：时间校正器
    @Test
    public void test() {
        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println(ldt1);

        LocalDateTime ldt2 = ldt1.withDayOfMonth(10);
        System.out.println(ldt2);

        //下一个星期日
        LocalDateTime ldt3 = ldt1.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt3);

        //自定义：下一个工作日
        LocalDateTime ldt5 = ldt1.with((l) -> {
            LocalDateTime ldt4 = (LocalDateTime) l;

            //获取今天是星期几
            DayOfWeek dow = ldt4.getDayOfWeek();

            if (dow.equals(DayOfWeek.FRIDAY)) {
                //星期五下一个工作日是三天后
                return ldt4.plusDays(3);
            } else if (dow.equals(DayOfWeek.SATURDAY)) {
                //星期六下一个工作日是二天后
                return ldt4.plusDays(2);
            } else {
                //其它时间都是明天
                return ldt4.plusDays(1);
            }
        });
        System.out.println(ldt5);

        System.out.println("-----");

        //参数temporal就是调用with方法的那个日期
        ldt2.with(new TemporalAdjuster() {
            @Override
            public Temporal adjustInto(Temporal temporal) {
                System.out.println(temporal);
                return null;
            }
        });
    }

    //2. DateTimeFormatter ：格式化时间/日期
    @Test
    public void test2() {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime ldt = LocalDateTime.now();

        String strDate = ldt.format(dtf);
        System.out.println(strDate);

        System.out.println("-----");

        //自定义转换的格式
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String strDate2 = dtf2.format(ldt);
        System.out.println(strDate2);

        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        LocalDateTime ldt2 = LocalDateTime.parse("2018年05月06日 18:30:30", dtf3);
        System.out.println(ldt2);
    }

    //3. ZonedDate、ZonedTime、ZonedDateTime ：时区
    @Test
    public void test3() {
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(ldt);

        LocalDateTime ldt2 = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(ldt2);

        ZonedDateTime zdt = ldt2.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zdt);
    }

}
