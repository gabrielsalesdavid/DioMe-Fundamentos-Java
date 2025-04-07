package com.datecalendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Aula02 {

    public static void main(String[] args) {

        Calendar calend = Calendar.getInstance();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = Calendar.getInstance().getTime();
        calend.setTime(date);
        System.out.println(formatter.format(calend.getTime()));
    }
}