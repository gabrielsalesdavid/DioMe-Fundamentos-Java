package com.datecalendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Aula01 {

    public static void main(String[] args) {

        Date date = new Date();

        DateFormat dtFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println(date);
        System.out.println(dtFormat.format(date));
        date.setYear(32);
        System.out.println(date);
    }
}