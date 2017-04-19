package com.kunlun.api.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具
 * Created by kunlun on 2017/4/12.
 */
public class DateUtils {

    private static final String DEFAULT_DATETIME_FORMAT ="yyyy-MM-dd HH:mm:ss";

    private static final String DEFAULT_DATE_FORMAT="yyyy-MM-dd";

    /**
     * 生成指定格式的日期字符串
     * @param format
     * @return
     */
    public static String datetime(String format){
        SimpleDateFormat formatt = new SimpleDateFormat(format);
        return formatt.format(new Date());
    }

    /**
     * 生成指定日期  格式的  日期字符串
     * @param date
     * @param format
     * @return
     */
    public static String datetime(Date date,String format){
        SimpleDateFormat formatt = new SimpleDateFormat(format);
        return formatt.format(date);
    }

    /**
     * 生成指定日期  格式的   日期字符串
     * @param date
     * @param format
     * @return
     */
    public static String dateTime(String date,String format){
        SimpleDateFormat formatt = new SimpleDateFormat(format);
        return formatt.format(date);
    }
}
