package com.gfr.improve.util;

import org.springframework.util.DigestUtils;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/18 4:25 下午
 * @description：使用MD5加密密码
 * @modified By：
 * @version: 1.0
 */
public class EncryptionUtil {

    private static final String SLAT = "improve";

    /**
     * 将字符串进行加密
     * @param str
     * @return
     */
    public static String Encryption(String str){
        int index = str.length() / 2;
        StringBuffer stringBuffer = new StringBuffer();

        //拼接加密盐
        stringBuffer.append(str.substring(0, index));
        stringBuffer.append(SLAT);
        stringBuffer.append(str.substring(index, str.length()));

        return DigestUtils.md5DigestAsHex(stringBuffer.toString().getBytes());
    }

    /**
     * 对未加密字符串str1 使用str2 进行验证
     * @param str1
     * @param str2
     * @return
     */
    public static boolean Verification(String str1, String str2){
        return Encryption(str1).equals(str2);
    }
}
