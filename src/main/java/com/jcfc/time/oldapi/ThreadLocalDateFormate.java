package com.jcfc.time.oldapi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalDateFormate {

    private static final ThreadLocal<DateFormat> tl = new ThreadLocal<DateFormat>() {
        //给ThreadLocal设置初始value值
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };

    public static Date parse(String source) throws ParseException {
        return tl.get().parse(source);
    }

}
