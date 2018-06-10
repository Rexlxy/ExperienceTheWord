package com.ETW;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class DateUtil {

    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

    public static String millisToString(long timeMillis, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        return simpleDateFormat.format(timeMillis);
    }

    public static String millisToString(long timeMillis) {
        return simpleDateFormat.format(timeMillis);
    }

    public static String millisToStringWithTimeZone(long timeMillis, String dateFormat, String timezone) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return simpleDateFormat.format(timeMillis);
    }

}
