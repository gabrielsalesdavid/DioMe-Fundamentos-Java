package com.exercicos;

import com.exercicos.domain.BRLClock;
import com.exercicos.domain.Clock;
import com.exercicos.domain.USClock;

public class Exercicio04 {

    public static void main(String[] agrs) {

        Clock brlCok = new BRLClock();
        brlCok.setSecond(0);
        brlCok.setMinute(0);
        brlCok.setHour(25);

        System.out.println(brlCok.getTime());
        System.out.println(new USClock().convert(brlCok).getTime());
    }
}