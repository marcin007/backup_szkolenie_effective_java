package com.for_comprehension.function;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

class L3_UnmodifiableJava {
    public static void main(String[] args) {
        var list = List.of(1);
        // list.add(42); exception!

        // old school modifiable date API
        Date date = new Date();
        date.setTime(date.getTime() + 1000);

        // modern date API
        LocalTime now = LocalTime.now();
        LocalTime nowPlusHour = now.plusHours(1);
    }

    public static double divide(int a, int b) {
        return a/b;
    }
}
