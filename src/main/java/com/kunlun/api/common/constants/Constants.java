package com.kunlun.api.common.constants;

/**
 * 系统常量值
 * Created by kunlun on 2017/4/17.
 */
public class Constants {


    /**
     * 手机号校验正则表达式
     */
    public static final String MOBILE_REGEXP = "^(((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\\\\d{8})$";

    /**
     * PBK加密算法
     */
    public static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";

    /**
     * Token加密算法
     */
    public static final String TOKEN_ALGORITHM = "AES/ECB/PKCS5Padding";

    /**
     * Token逆向秘钥
     */
    public static final String TOKEN_KEY = "LEKWRVOUHAYCSQCR";

    /**
     * 盐的长度
     */
    public static final int SALT_BYTE_SIZE = 40 / 2;

    /**
     * 生成密文的长度
     */
    public static final int HASH_BIT_SIZE = 128 * 6;

    /**
     * 迭代次数
     */
    public static final int PBKDF2_ITERATORS = 2000;

    /**
     * 固定盐
     */
    public static final String ENCRYPT_SALT = "ed1936ff13f5c5776dc39a2503044af99b02b369";

    /**
     * 默认密码
     */
    public static final String DEFAULT_PASSWORD = "888888";

    /**
     * redis记录在线用户使用key
     */
    public static final String ON_LINE="on_line:";

}
