package com.example.mymusic.util;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 字符串工具类测试
 */
public class StringUtilTest {
    /**
     * 测试是否是手机号
     */
    @Test
    public void testIsPhone()
    {
        //这是一个正确的手机号格式
        //所以用断言判断结果为true
        //只有结果为true才表示测试通过
        //也就表示我们的代码没问题

        //这里的assert其实是junit中的
        assertTrue(StringUtil.isPhone("13141111111"));

        //这是一个错误的手机号格式
        //所以用断言判断结果为false
        assertFalse(StringUtil.isPhone("ixuea"));
    }

}
