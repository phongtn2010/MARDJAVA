package com.nsw.backend.test;

import java.util.Calendar;

public class TestClass {
    public static void main(String[] args) {
        int ngay=25;
        int thang=9;
        int nam=2020;
        Calendar to =Calendar.getInstance();
        to.set(Calendar.HOUR_OF_DAY,23);
        to.set(Calendar.MINUTE,59);
        to.set(Calendar.SECOND,59);

        to.set(Calendar.DAY_OF_MONTH,ngay);
        to.set(Calendar.MONTH,thang-1);
        to.set(Calendar.YEAR,nam);
        System.out.println(to.getTime());
    }
}
