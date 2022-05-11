package com.example.anime.temporyPackage.Util;

import java.util.Random;

/**
 * 本类用于随机生成盐；
 */
public class SaltGenerateUtil {
    public static String GenerateSalt(int n){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890!@#$%^&*()".toCharArray();
        StringBuilder tempVessel = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            tempVessel.append(aChar);
        }
        return tempVessel.toString();
    }
}
