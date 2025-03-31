package com.exercicos.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public non-sealed class USClock extends Clock {

    private String periodIndicator;

    public String setAfterMidday() {

        return this.periodIndicator = "PM";
    }

    public String setBeforeMidday() {

        return this.periodIndicator = "AM";
    }

    public void setHour(int hour) {

        setBeforeMidday();
        if((hour > 12) && (hour <= 23)) {

            setAfterMidday();
            this.hour = hour - 12;
        } else if(hour >= 24) {

            this.hour = 0;
        } else {

            this.hour = hour;
        }
    }

    @Override
    public Clock convert(Clock clock) {

        this.second = clock.getSecond();
        this.minute = clock.getMinute();

        switch (clock) {

            case USClock usClock -> {
                this.hour = usClock.getHour();
                this.periodIndicator = usClock.getPeriodIndicator();
            }

            case BRLClock brlClock -> this.setHour(brlClock.getHour());
        }

        return this;
    }

    public String getTme() {

        return super.getTime() + " " + this.periodIndicator;
    }
}