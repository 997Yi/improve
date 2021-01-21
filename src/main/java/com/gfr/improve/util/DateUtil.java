package com.gfr.improve.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/21 10:08
 * @description：日期工具
 * @modified By：
 * @version: 1.0
 */
public class DateUtil {
    public static boolean checkTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date time = calendar.getTime();

        return date.after(time);
    }
}
