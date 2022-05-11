package com.example.anime.temporyPackage.Util;

import com.example.anime.Entity.administratorManagementEntity.LogBoardManagementDataEntity;

import java.util.List;

public class LogPreserveUtil {
    public List logExecute(String executor, String executeEvent, String accessInterface, String remark){
        GenerateNumberUtil generateNumberUtil = new GenerateNumberUtil();
        LogBoardManagementDataEntity logBoardManagementDataEntity = new LogBoardManagementDataEntity();

        logBoardManagementDataEntity.setLogNumber(generateNumberUtil.generateLogNumber());
        logBoardManagementDataEntity.setExecutor(executor);
        logBoardManagementDataEntity.setExecuteEvent(executeEvent);
        logBoardManagementDataEntity. setAccessInterface(accessInterface);
        logBoardManagementDataEntity.setRemark(remark);
        logBoardManagementDataEntity.setExecutionTime(generateNumberUtil.generateDate());
        return (List) logBoardManagementDataEntity;
    }
}
