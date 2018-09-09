package com.umbrella.financialteaching.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenjun on 18/9/9.
 */

public class DateUtil {
    public static String getStringDate() {
        Date currentDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = simpleDateFormat.format(currentDate);
        return dateString;
    }
}
