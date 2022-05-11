package com.example.anime.Controller.individualInformationDataController;

import com.example.anime.Entity.individualInformationDataEntity.ExpandSkillsDataEntity;
import com.example.anime.Service.administratorManagementService.LogBoardManagementDataService;
import com.example.anime.temporyPackage.Util.LogPreserveUtil;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.anime.Service.individualInformationDataService.ExpandSkillsDataService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("individual")
public class ExpandSkillsDataController {
    @Autowired
    private ExpandSkillsDataService expandSkillsDataService;
    @Autowired
    private LogBoardManagementDataService logBoardManagementDataService;

    @RequestMapping("getExpandSkillsData")
    @ResponseBody
    public List<ExpandSkillsDataEntity> getExpandSkillsData(String userName, String location){
        logBoardManagementDataService.addLogBoard(userName,"执行了获取拓展技能的操作","/individual/getExpandSkillsData","暂无备注！");
        return expandSkillsDataService.getExpandSkillsData(userName, location);
    }

    @RequestMapping("modifyExpandSkillsData")
    @ResponseBody
    public Integer modifyExpandSkillsData(ExpandSkillsDataEntity expandSkillsDataEntity){
        String userName = expandSkillsDataEntity.getUserName();
        logBoardManagementDataService.addLogBoard(userName,"执行了修改拓展技能的操作","/individual/modifyExpandSkillsData","暂无备注！");
        return expandSkillsDataService.modifyExpandSkillsData(expandSkillsDataEntity);
    }

    @RequestMapping("deleteExpandSkillsData")
    @ResponseBody
    public Integer deleteExpandSkillsData(String userName, String location){
        logBoardManagementDataService.addLogBoard(userName,"执行了删除拓展技能的操作","/individual/deleteExpandSkillsData","暂无备注！");
        return expandSkillsDataService.deleteExpandSkillsData(userName, location);
    }

    @RequestMapping("deleteAllExpandSkillsData")
    @ResponseBody
    public Integer deleteAllExpandSkillsData(String userName){
        logBoardManagementDataService.addLogBoard(userName,"执行了删除所有拓展技能的操作","/individual/deleteAllExpandSkillsData","暂无备注！");
        return expandSkillsDataService.deleteAllExpandSkillsData(userName);
    }

    @RequestMapping("addExpandSkillsData")
    @ResponseBody
    public Integer addExpandSkillsData(ExpandSkillsDataEntity expandSkillsDataEntity){
        String userName = expandSkillsDataEntity.getUserName();
        logBoardManagementDataService.addLogBoard(userName,"执行了增加拓展技能的操作","/individual/addExpandSkillsData","暂无备注！");
        return expandSkillsDataService.addExpandSkillsData(expandSkillsDataEntity);
    }

}
