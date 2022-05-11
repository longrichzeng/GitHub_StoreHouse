package com.example.anime.Service.administratorManagementService.administratorManagementServiceImpl;

import com.example.anime.Entity.administratorManagementEntity.LogBoardManagementDataEntity;
import com.example.anime.Service.administratorManagementService.LogBoardManagementDataService;
import com.example.anime.temporyPackage.Util.GenerateNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.anime.Dao.administratorManagementDao.LogBoardManagementDataDao;

import java.util.List;

@Service
public class LogBoardManagementDataServiceImpl implements LogBoardManagementDataService {
    @Autowired
    private LogBoardManagementDataDao logBoardManagementDataDao;

    @Override
    public List<LogBoardManagementDataEntity> getLogBoardData(){
        return logBoardManagementDataDao.getLogBoardData();
    }

    @Override
    public List<LogBoardManagementDataEntity> getLogBoardByTime(String executionTime){
        return logBoardManagementDataDao.getLogBoardByTime(executionTime);
    }

    @Override
    public List<LogBoardManagementDataEntity> getLogBoardByUsername(String executor){
        return logBoardManagementDataDao.getLogBoardByUsername(executor);
    }

    @Override
    public Integer addLogBoard(String executor, String executeEvent, String accessInterface, String remark){
        LogBoardManagementDataEntity logBoardManagementDataEntity = new LogBoardManagementDataEntity();
        logBoardManagementDataEntity.setExecutor(executor);
        logBoardManagementDataEntity.setExecuteEvent(executeEvent);
        logBoardManagementDataEntity.setAccessInterface(accessInterface);
        logBoardManagementDataEntity.setRemark(remark);

        GenerateNumberUtil generateNumberUtil = new GenerateNumberUtil();
        if(executor != null && executeEvent != null && accessInterface != null && remark != null) {
            logBoardManagementDataEntity.setLogNumber(generateNumberUtil.generateLogNumber());
            logBoardManagementDataEntity.setExecutionTime(generateNumberUtil.generateDate());
            logBoardManagementDataDao.addLogBoard(logBoardManagementDataEntity);
            return 1;
        }else{
            logBoardManagementDataDao.addLogBoard(null);
            return 0;
        }
    }

    @Override
    public Integer deleteLogBoardData(String logNumber){
        for(int i = 0; i < 10; i++){
            logBoardManagementDataDao.deleteLogBoardData(logNumber);
        }
        return 1;
    }
}
