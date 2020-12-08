package com.example.mymusic.util;
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
    /**
     * 手机号正则表达式
     * 移动：134 135 136 137 138 139 147 150 151 152 157 158 159 178 182 183 184 187 188 198
     * 联通：130 131 132 145 155 156 166 171 175 176 185 186
     * 电信：133 149 153 173 177 180 181 189 199
     * 虚拟运营商: 170
     */
    public static final String REGEX_PHONE = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";

}
