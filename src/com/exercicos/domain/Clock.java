package com.exercicos.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public sealed abstract class Clock permits BRLClock, USClock {

    protected int hour;
    protected int minute;
    protected int second;

    public void setHour(int hour) {

        if(hour >= 24) {

            this.hour = 24;
            return;
        }

        this.hour = hour;
    }

    public void setMinute(int minute) {

        if(minute >= 60) {

            this.minute = 60;
            return;
        }

        this.minute = minute;
    }

    public void setSecond(int second) {

        if(second >= 60) {

            this.second = 60;
            return;
        }

        this.second = second;
    }

    private String format(int value) {

        return value < 9 ? "0" + value : String.valueOf(value);
    }

    public String getTime() {

        return format(hour) + ":" + format(minute) + ":" + format(second);
    }

    abstract Clock convert(Clock clock);
}