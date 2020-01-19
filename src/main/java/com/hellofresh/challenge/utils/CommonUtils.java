package com.hellofresh.challenge.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class CommonUtils {

    public static String createRamdomString() {
        return RandomStringUtils.randomAlphanumeric(12);
    }

    public static String createRandomFirstLastName() {
        return RandomStringUtils.random(10, true, false);
    }

    public static Integer createRandomNumber() {
        return Integer.valueOf(RandomStringUtils.randomNumeric(1));
    }

}
