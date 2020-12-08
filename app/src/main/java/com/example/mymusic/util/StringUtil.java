package com.example.mymusic.util;

import static com.example.mymusic.util.Constant.REGEX_EMAIL;
import static com.example.mymusic.util.Constant.REGEX_PHONE;

/*
字符串相关工具类
 */
public class StringUtil {

    /**
     * 是否是手机号
     * @param value
     * @return
     */
    public static boolean isPhone(String value)
    {
        return value.matches(REGEX_PHONE);
    }


    public static boolean isEmail(String value)
    {
        return value.matches(REGEX_EMAIL);
    }

    public static boolean isPassword(String value) {
        return value.length()>=6&&value.length()<=15;

    }
}
