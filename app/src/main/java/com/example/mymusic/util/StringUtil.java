package com.example.mymusic.util;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import static com.example.mymusic.util.Constant.REGEX_EMAIL;
import static com.example.mymusic.util.Constant.REGEX_PHONE;

/*
字符串相关工具类
 */
public class StringUtil {


    /**
     * 是否是手机号
     *
     * @param value
     * @return
     */
    public static boolean isPhone(String value) {
        return value.matches(REGEX_PHONE);
    }

    /**
     * 是否是邮箱
     *
     * @param value
     * @return
     */
    public static boolean isEmail(String value) {
        return value.matches(REGEX_EMAIL);
    }

    /**
     * 是否符合密码格式
     *
     * @param value
     * @return
     */
    public static boolean isPassword(String value) {
        return value.length() >= 6 && value.length() <= 15;
    }

    /**
     * 是否符合昵称格式
     *
     * @param value
     * @return
     */
    public static boolean isNickname(String value) {
        return value.length() >= 2 && value.length() <= 10;
    }

    /**
     * 是否符合验证码格式
     *
     * @param value
     * @return
     */
    public static boolean isCode(String value) {
        return value.length() == 4;
    }

    /**
     * 将一行字符串
     * 拆分为单个字
     * <p>
     * 只实现了中文
     * 英文是有问题的
     * 大家感兴趣可以在继续实现
     *
     * @param data
     * @return
     */
    public static String[] words(String data) {
        //创建一个列表
        List<String> results = new ArrayList<>();

        //转为char数组
        char[] chars = data.toCharArray();

        //循环每一个字符
        for (char c : chars
        ) {
            //转为字符串
            //冰添加到列表
            results.add(String.valueOf(c));
        }

        //转为数组
        return results.toArray(new String[results.size()]);
    }




    /**
     * 给用户id添加占位字符
     *
     * @param data
     * @return
     */
    public static String wrapperUserId(String data) {
        return "100" + data;
    }

    /**
     * 去除用户id占位符
     *
     * @param data
     * @return
     */
    public static String unwrapUserId(String data) {
        return data.substring(3);
    }

    /**
     * 格式化消息数量
     *
     * @param data
     * @return
     */
    public static String formatMessageCount(int data) {
        if (data > 99) {
            return "99+";
        }

        return String.valueOf(data);
    }

}
