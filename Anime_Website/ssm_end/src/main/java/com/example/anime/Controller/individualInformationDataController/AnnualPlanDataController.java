package com.example.anime.Controller.individualInformationDataController;

import com.example.anime.Entity.individualInformationDataEntity.AnnualPlanDataEntity;
import com.example.anime.Service.administratorManagementService.LogBoardManagementDataService;
import com.example.anime.temporyPackage.Util.LogPreserveUtil;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.anime.Service.individualInformationDataService.AnnualPlanDataService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("individual")
public class AnnualPlanDataController {
    @Autowired
    private AnnualPlanDataService annualPlanDataService;
    @Autowired
    private LogBoardManagementDataService logBoardManagementDataService;

    @RequestMapping("getAnnualPlanData")
    @ResponseBody
    public List<AnnualPlanDataEntity> getAnnualPlanData(String userName){
        logBoardManagementDataService.addLogBoard(userName,"执行了获取年度计划的操作","/individual/getAnnualPlanData","暂无备注！");
        return annualPlanDataService.getAnnualPlanData(userName);
    }

    @RequestMapping("modifyAnnualPlanData")
    @ResponseBody
    public Integer modifyAnnualPlanData(AnnualPlanDataEntity annualPlanDataEntity){
        String userName = annualPlanDataEntity.getUserName();
        logBoardManagementDataService.addLogBoard(userName,"执行了修改年度计划的操作","/individual/modifyAnnualPlanData","暂无备注！");
        return annualPlanDataService.modifyAnnualPlanData(annualPlanDataEntity);
    }

    @RequestMapping("deleteAnnualPlanData")
    @ResponseBody
    public Integer deleteAnnualPlanData(String userName, String location){
        logBoardManagementDataService.addLogBoard(userName,"执行了删除年度计划的操作","/individual/deleteAnnualPlanData","暂无备注！");
        return annualPlanDataService.deleteAnnualPlanData(userName, location);
    }

    @RequestMapping("deleteAllAnnualPlanData")
    @ResponseBody
    public Integer deleteAllAnnualPlanData(String userName){
        logBoardManagementDataService.addLogBoard(userName,"执行了删除所有年度计划的操作","/individual/deleteAllAnnualPlanData","暂无备注！");
        return annualPlanDataService.deleteAllAnnualPlanData(userName);
    }

    @RequestMapping("addAnnualPlanData")
    @ResponseBody
    public Integer addAnnualPlanData(AnnualPlanDataEntity annualPlanDataEntity){
        String userName = annualPlanDataEntity.getUserName();
        logBoardManagementDataService.addLogBoard(userName,"执行了添加年度计划的操作","/individual/addAnnualPlanData","暂无备注！");
        return annualPlanDataService.addAnnualPlanData(annualPlanDataEntity);
    }
}
