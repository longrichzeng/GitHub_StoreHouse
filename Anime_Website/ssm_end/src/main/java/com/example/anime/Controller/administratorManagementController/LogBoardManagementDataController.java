package com.example.anime.Controller.administratorManagementController;

import com.example.anime.Service.administratorManagementService.LogBoardManagementDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.anime.Entity.administratorManagementEntity.LogBoardManagementDataEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("administrator")
public class LogBoardManagementDataController {
    @Autowired
    private LogBoardManagementDataService logBoardManagementDataService;

    @RequestMapping("getLogBoardData")
    @ResponseBody
    public List<LogBoardManagementDataEntity> getLogBoardData(){
        return logBoardManagementDataService.getLogBoardData();
    }

    @RequestMapping("getLogBoardByTime")
    @ResponseBody
    public List<LogBoardManagementDataEntity> getLogBoardByTime(String executionTime){
        return logBoardManagementDataService.getLogBoardByTime(executionTime);
    }

    @RequestMapping("getLogBoardByUsername")
    @ResponseBody
    public List<LogBoardManagementDataEntity> getLogBoardByUsername(String executor){
        return logBoardManagementDataService.getLogBoardByUsername(executor);
    }

    @RequestMapping("deleteLogBoardData")
    @ResponseBody
    public Integer deleteLogBoardData(String logNumber){
        for(int i = 0; i < 10; i++){
            logBoardManagementDataService.deleteLogBoardData(logNumber);
        }
        return 1;
    }
}
