package org.levelup.bank.util;

import java.sql.Date;
import java.time.LocalDate;

public class DateUtils {

    private DateUtils() {}

    public static Date ofLocalDate(LocalDate localeDate) {
        if (localeDate == null) {
            return null;
        }

        return Date.valueOf(localeDate);
    }

    public static LocalDate ofDate(Date date) {
        if (date == null) {
            return null;
        }
        return date.toLocalDate();
    }
}
