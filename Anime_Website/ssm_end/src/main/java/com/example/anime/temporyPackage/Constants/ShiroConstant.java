package com.example.anime.temporyPackage.Constants;

public class ShiroConstant {
    /**static表明这个变量是静态的，不能被修改的；而final表示这个变量不能被继承；**/

    /**随机生成的盐的长度**/
    public static final int SALT_LENGTH = 8;

    /**hash的散列次数**/
    public static final int HASH_ITERATORS = 10;

    /**定义加密方式**/
    public interface HASH_ALGORITHM_NAME {
        String MD5 = "MD5";
    }
}
