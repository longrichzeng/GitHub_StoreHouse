package com.example.anime.temporyPackage.Util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GenerateNumberUtil {
    /**
     * 生成动漫番剧的编号
     * @return
     */
    public String generateAnimeDrameNumber(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMss");
        Date date = new Date();
        String hehe = dateFormat.format(date);
        int randomString = new Random().nextInt(999);
        if(randomString < 10)
            return hehe + "A00" + String.valueOf(randomString);
        else if(randomString < 100)
            return hehe + "A0" + String.valueOf(randomString);
        else
            return hehe + "A" + String.valueOf(randomString);
    }

    /**
     * 生成动漫音乐的编号
     * @return
     */
    public String generateAnimeMusicNumber(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMss");
        Date date = new Date();
        String hehe = dateFormat.format(date);
        int randomString = new Random().nextInt(999);
        if(randomString < 10)
            return hehe + "M00" + String.valueOf(randomString);
        else if(randomString < 100)
            return hehe + "M0" + String.valueOf(randomString);
        else
            return hehe + "M" + String.valueOf(randomString);
    }

    /**
     * 生成景品手办的编号
     * @return
     */
    public String generateJinpinNumber(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddss");
        Date date = new Date();
        String hehe = dateFormat.format(date);
        int randomString = new Random().nextInt(9999);
        if(randomString < 10)
            return hehe + "JP000" + String.valueOf(randomString);
        else if(randomString < 100)
            return hehe + "JP00" + String.valueOf(randomString);
        else if(randomString < 1000)
            return hehe + "JP0" + String.valueOf(randomString);
        else
            return hehe + "JP" + String.valueOf(randomString);
    }

    /**
     * 生成日志的编号
     * @return
     */
    public String generateLogNumber(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddss");
        Date date = new Date();
        String hehe = dateFormat.format(date);
        int randomString = new Random().nextInt(9999);
        if(randomString < 10)
            return hehe + "Log000" + String.valueOf(randomString);
        else if(randomString < 100)
            return hehe + "Log00" + String.valueOf(randomString);
        else if(randomString < 1000)
            return hehe + "Log0" + String.valueOf(randomString);
        else
            return hehe + "Log" + String.valueOf(randomString);
    }

    /**
     * 生成笔记的编号
     * @return
     */
    public String generateNotesNumber(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddss");
        Date date = new Date();
        String hehe = dateFormat.format(date);
        int randomString = new Random().nextInt(9999);
        if(randomString < 10)
            return hehe + "Notes000" + String.valueOf(randomString);
        else if(randomString < 100)
            return hehe + "Notes00" + String.valueOf(randomString);
        else if(randomString < 1000)
            return hehe + "Notes0" + String.valueOf(randomString);
        else
            return hehe + "Notes" + String.valueOf(randomString);
    }

    /**
     * 生成数据的编号
     * @return
     */
    public String generateDataNumber(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddss");
        Date date = new Date();
        String hehe = dateFormat.format(date);
        int randomString = new Random().nextInt(9999);
        if(randomString < 10)
            return hehe + "data000" + String.valueOf(randomString);
        else if(randomString < 100)
            return hehe + "data00" + String.valueOf(randomString);
        else if(randomString < 1000)
            return hehe + "data0" + String.valueOf(randomString);
        else
            return hehe + "data" + String.valueOf(randomString);
    }

    /**
     * 生成时间字符串
     * @return
     */
    public String generateDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        String hehe = dateFormat.format(date);
        return hehe ;
    }

    /**
     * 生成日期字符串
     * @return
     */
    public String generateTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String hehe = dateFormat.format(date);
        return hehe ;
    }
}
