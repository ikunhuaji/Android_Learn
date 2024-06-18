package com.software.androidhomework.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMethod {
    public static String getDate(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        String nowDate = format.format(date);

        return nowDate;
    }

    public static void main(String[] args) {
        System.out.println(getDate());
    }
}
