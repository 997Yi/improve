package com.gfr.improve.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/21 10:08
 * @description：日期工具
 * @modified By：
 * @version: 1.0
 */
public class DateUtil {
    public static boolean checkTime(Date date){
        return date.after(getStart());
    }


    public static Date getStart(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }

    public static Date addDay(Date date, int amount){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, amount);

        return calendar.getTime();
    }

    /**
     * target为期限，但是需要对target进行加一天
     * @param date
     * @param target
     * @return
     */
    public static boolean isInTime(Date date, Date target){
        return date.before(addDay(target, 1));
    }
}
