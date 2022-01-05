package com.cn.leetcode2022;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author HUANG Zuo
 * @version create_time：2022-01-03 20:55:23
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class DayOfTheWeek_1185 {

    private final String[] days = new String[]{"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday" };


    public String dayOfTheWeek(int day, int month, int year) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        String inputString1 = "19710101";
        String inputString2 = getYearString(year, month, day);
        LocalDate date1 = LocalDate.parse(inputString1, dtf);
        LocalDate date2 = LocalDate.parse(inputString2, dtf);
        long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        return days[(int) (daysBetween % 7) ];
    }

    private String getYearString(int year, int month, int day) {
        String res = "";
        res += year;
        res += month < 10 ? "0" + month : month;
        res += day < 10 ? "0" + day : day;
        return res;
    }


    public static void main(String[] args) {
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
//        String inputString1 = "19710101";
//        String inputString2 = "19970124";
//        LocalDate date1 = LocalDate.parse(inputString1, dtf);
//        LocalDate date2 = LocalDate.parse(inputString2, dtf);
//        long daysBetween = ChronoUnit.DAYS.between(date1, date2);
//        System.out.println(daysBetween);
        DayOfTheWeek_1185 dayOfTheWeek_1185 = new DayOfTheWeek_1185();
        System.out.println(dayOfTheWeek_1185.dayOfTheWeek(3, 1, 2022));
    }


}
