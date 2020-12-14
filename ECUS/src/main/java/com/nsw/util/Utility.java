/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsw.util;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author PhongNguyen
 */
public class Utility {

    private static final String EMAIL_PATTERN = "^([\\w\\d\\-\\.]+)@{1}(([\\w\\d\\-]{1,67})|([\\w\\d\\-]+\\.[\\w\\d\\-]{1,67}))\\.(([a-zA-Z\\d]{2,4})(\\.[a-zA-Z\\d]{2})?)$";

    public static final Logger logger = LoggerFactory.getLogger(Utility.class);

    public static boolean IsDecimal(String d, String precision, String scale) {
        String p = "";
        switch (scale) {
            case "-1":
                break;
            case "0":
                p = ("^[0-9]{0,"
                        + (precision + "}$"));
                break;
            default:
                p = ("^[0-9]{0,"
                        + (precision + ("}(\\.[0-9]{1,"
                        + (scale + "})?$"))));
                break;
        }
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(d);
        return matcher.matches();
    }

    public static boolean IsEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean IsDate(String d) {
        try {
            Date dt = new Date(d);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
