package com.example.hackstival.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Constant {

    private Constant() {

    }

    public final static DateTimeFormatter FULL_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public final static DateTimeFormatter SIMPLE_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

    public static LocalDateTime parseFullDateTime(String time) {
        return LocalDateTime.parse(time + ":00", FULL_DATE_FORMATTER);
    }
}
