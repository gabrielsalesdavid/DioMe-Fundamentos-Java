package com.offsetdatetimelocaldatedatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Aula01 {

    public static void main(String[] args) {

        LocalDate lclDate = LocalDate.now();
        String strDate = "11/10/1992";
        DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(LocalDate.parse(strDate, dtFormat));
        LocalTime lclTime = LocalTime.now();
        DateTimeFormatter dtTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime lclDateTime = LocalDate.now().atTime(lclTime);

        Date dt = new Date();
        Calendar clna = Calendar.getInstance();
        clna.setTime(dt);
        ZoneId znId = clna.getTimeZone().toZoneId();
        LocalDateTime lclDtTime = LocalDateTime.ofInstant(clna.toInstant(), znId);
        System.out.println(lclDtTime);
    }
}