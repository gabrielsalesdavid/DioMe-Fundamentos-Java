package com.stringbuilderbuffer;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

public class Aula02 {

    public static void main(String[] args) {

        String stringConcat = "value";
        stringConcat += "2";

        System.out.println(stringConcat);

        var stringStart = OffsetDateTime.now();
        String stringConcat01 = "";
        for(int i = 0; i < 1_00_000; i++) {

            stringConcat01 += i;
        }
        var stringEnd = OffsetDateTime.now();

        System.out.printf("String: %s \n", getInterval(stringStart, stringEnd));

        var builderStart = OffsetDateTime.now();
        StringBuilder builderConcat = new StringBuilder();
        for(int i = 0; i < 1_000_000; i++) {

            builderConcat.append(i);
        }
        var builderEnd = OffsetDateTime.now();

        System.out.printf("StringBuilder (singlethread): %s \n", getInterval(builderStart, builderEnd));

        var bufferStart = OffsetDateTime.now();
        StringBuffer bufferConcat = new StringBuffer();
        for(int i = 0; i < 1_000_000; i++) {

            builderConcat.append(i);
        }
        var bufferEnd = OffsetDateTime.now();
        System.out.printf("StringBuilder (singlethread): %s \n", getInterval(bufferStart, bufferEnd));
    }

    private static long getInterval(final OffsetDateTime stringStart, final OffsetDateTime stringEnd) {

        return Duration.between(stringStart, stringEnd).toSeconds();
    }
}