package com.example.anime.Dto;

public class DataGeneratedDailyDTO {
    private String dataId;
    private int userDailyRegis;
    private int dailyLoginOfUsers;
    private int dailyPurchasesOfJinpin;
    private String dateTime;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public int getUserDailyRegis() {
        return userDailyRegis;
    }

    public void setUserDailyRegis(int userDailyRegis) {
        this.userDailyRegis = userDailyRegis;
    }

    public int getDailyLoginOfUsers() {
        return dailyLoginOfUsers;
    }

    public void setDailyLoginOfUsers(int dailyLoginOfUsers) {
        this.dailyLoginOfUsers = dailyLoginOfUsers;
    }

    public int getDailyPurchasesOfJinpin() {
        return dailyPurchasesOfJinpin;
    }

    public void setDailyPurchasesOfJinpin(int dailyPurchasesOfJinpin) {
        this.dailyPurchasesOfJinpin = dailyPurchasesOfJinpin;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
