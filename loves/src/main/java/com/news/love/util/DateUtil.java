package com.news.love.util;

/**
 * Created by Administrator on 2017/9/25.
 */

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 */
public class DateUtil {

    /**********************************************************
     * 指定格式格式化时间
     * @param date 时间
     * @param format 格式化标准
     * @return 格式化时间字符串
     **********************************************************/
    public static String getFormatDate(Date date , String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateFormat = sdf.format(date);
        return dateFormat;
    }

    /*******************************************************************
     * 指定格式格式化时间
     * @param time 时间字符串
     * @param format 格式化标准
     * @return 格式化时间字符串
     *******************************************************************/
    public static String transferFormatDate(String time , String format){
        String dateFormat = "";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        SimpleDateFormat sdfC = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try{
            Date date = sdf.parse(time);
            dateFormat = sdfC.format(date);
        } catch (Exception e){
            e.printStackTrace();
        }
        return dateFormat;
    }

    public static void main(String[] args) {
        System.out.print(DateUtil.getFormatDate(new Date(),"yyyy-MM-dd HH:mm"));
        System.out.print(transferFormatDate("2017-09-25 18:34","yyyy-MM-dd HH"));
    }
}
