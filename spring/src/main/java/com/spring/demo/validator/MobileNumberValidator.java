package com.spring.demo.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileNumberValidator {

    // Regular expression for validating an Indian mobile number
    private static final String MOBILE_NUMBER_PATTERN = "^[56789]\\d{9}$";

    public static boolean isValidMobileNumber(String mobileNumber) {
        if (mobileNumber == null) {
            return false;
        }

        Pattern pattern = Pattern.compile(MOBILE_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(mobileNumber);
        return matcher.matches();
    }
}
