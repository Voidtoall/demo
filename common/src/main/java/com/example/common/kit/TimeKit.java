package com.example.common.kit;

import com.google.common.base.Preconditions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeKit {

    public static long getTimeDiffInHalfHours(String start) {
        return (long) Math.ceil((double)getTimeDiffInMillis(parseDate(start).getTime(), System.currentTimeMillis()) / 1800000);
    }
    
    public static long getTimeDiffInHalfHours(long start) {
        return (long) Math.ceil((double)getTimeDiffInMillis(start, System.currentTimeMillis()) / 1800000);
    }

    public static long getTimeDiffInHalfHours(String start, String end) {
        return (long) Math.ceil((double)getTimeDiffInMillis(parseDate(start).getTime(), parseDate(end).getTime()) / 1800000);
    }

    public static long getTimeDiffInMinutes(String start, String end) {
        return (long) Math.ceil((double)getTimeDiffInMillis(parseDate(start).getTime(), parseDate(end).getTime()) / 60000);
    }
    
    public static long getTimeDiffInMinutes(long start, long end) {
        return (long) Math.ceil((double)getTimeDiffInMillis(start, end) / 60000);
    }

    public static long getTimeDiffInSeconds(Long start) {
        return (long) Math.ceil((double)getTimeDiffInMillis(start, System.currentTimeMillis())/1000);
    }

    public static long getTimeDiffInSeconds(String start, String end) {
        return (long) Math.ceil((double)getTimeDiffInMillis(parseDate(start).getTime(), parseDate(end).getTime())/1000);
    }

    private static long getTimeDiffInMillis(long start, long end) {
        return end - start;
    }

    private static ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<>();

    private static SimpleDateFormat getDateFormat() {
        if (dateFormat.get() == null) {
            dateFormat.set(new SimpleDateFormat("yyyy-MM-dd kk:mm:ss"));
        }
        return dateFormat.get();
    }

    private static Date parseDate(String dateString) {
        Preconditions.checkNotNull(dateString, "input cannot be null");
        try {
            return getDateFormat().parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String[] args) {
       long i = TimeKit.getTimeDiffInMillis(1479349994943l, 1479350360084l);
       System.out.println(365141/1000/60);
       System.out.println(i);
    }

}
