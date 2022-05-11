package com.example.anime.temporyPackage.Util;

import java.util.Base64;

/**
 * 生成用于返回值前端的Token
 */
public class TokenGenerateUtil {
    public static String TokenGenerate(String username){
        String admin = "administrator" + username;
        for (int i = 0; i < 5; i++){
            admin = new String(Base64.getEncoder().encode(admin.getBytes()));
        }
        return admin;
    }
}
