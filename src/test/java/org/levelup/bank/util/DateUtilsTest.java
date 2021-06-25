package org.levelup.bank.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class DateUtilsTest {

    // test<MethodName>_when<InputPhrases(Parameters)>_then<WhatWillBe>
    @Test
    public void testOfLocalDate_whenInputIsNotNull_thenConvertToJavaUtilDate() {
        // given
        LocalDate testDate = LocalDate.of(2020, 1, 10);
        // when
        Date result = DateUtils.ofLocalDate(testDate);
        // then
        Assertions.assertEquals(testDate.atStartOfDay(ZoneId.systemDefault()).toEpochSecond() * 1000, result.getTime());
    }

    @Test
    public void testOfLocalDate_whenInputIsNull_thenReturnNull() {
        // given
        LocalDate testDate = null;
        // when
        Date result = DateUtils.ofLocalDate(testDate);
        // then
        Assertions.assertNull(result);
    }

}
