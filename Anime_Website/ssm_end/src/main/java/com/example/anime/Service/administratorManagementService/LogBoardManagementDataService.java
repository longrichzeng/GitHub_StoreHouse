package com.example.anime.Service.administratorManagementService;

import com.example.anime.Entity.administratorManagementEntity.AnimeDrameManagementDataEntity;
import com.example.anime.Entity.administratorManagementEntity.LogBoardManagementDataEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface LogBoardManagementDataService {
    List<LogBoardManagementDataEntity> getLogBoardData();

    List<LogBoardManagementDataEntity> getLogBoardByTime(String executionTime);

    List<LogBoardManagementDataEntity> getLogBoardByUsername(String executor);

    Integer addLogBoard(String executor, String executeEvent, String accessInterface, String remark);

    Integer deleteLogBoardData(String logNumber);
}
