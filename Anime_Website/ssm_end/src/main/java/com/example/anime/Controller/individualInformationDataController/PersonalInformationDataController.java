package com.example.anime.Controller.individualInformationDataController;

import com.example.anime.Entity.individualInformationDataEntity.PersonalInformationDataEntity;
import com.example.anime.Service.administratorManagementService.LogBoardManagementDataService;
import com.example.anime.temporyPackage.Util.LogPreserveUtil;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.anime.Service.individualInformationDataService.PersonalInformationDataService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("individual")
public class PersonalInformationDataController {
    @Autowired
    private PersonalInformationDataService personalInformationDataService;
    @Autowired
    private LogBoardManagementDataService logBoardManagementDataService;

    @RequestMapping("getPersonalInformationData")
    @ResponseBody
    public List<PersonalInformationDataEntity> getPersonalInformationData(String userName, String location){
        logBoardManagementDataService.addLogBoard(userName,"执行了获取个人信息的操作","/individual/getPersonalInformationData","暂无备注！");
        return personalInformationDataService.getPersonalInformationData(userName, location);
    }

    @RequestMapping("modifyPersonalInformationData")
    @ResponseBody
    public Integer modifyPersonalInformationData(PersonalInformationDataEntity personalInformationDataEntity){
        String userName = personalInformationDataEntity.getUserName();
        logBoardManagementDataService.addLogBoard(userName,"执行了修改个人信息的操作","/individual/modifyPersonalInformationData","暂无备注！");
        return personalInformationDataService.modifyPersonalInformationData(personalInformationDataEntity);
    }

    @RequestMapping("deletePersonalInformationData")
    @ResponseBody
    public Integer deletePersonalInformationData(String userName, String location){
        logBoardManagementDataService.addLogBoard(userName,"执行了删除个人信息的操作","/individual/deletePersonalInformationData","暂无备注！");
        return personalInformationDataService.deletePersonalInformationData(userName, location);
    }

    @RequestMapping("deleteAllPersonalInformationData")
    @ResponseBody
    public Integer deleteAllPersonalInformationData(String userName){
        logBoardManagementDataService.addLogBoard(userName,"执行了删除所有个人信息的操作","/individual/deleteAllPersonalInformationData","暂无备注！");
        return personalInformationDataService.deleteAllPersonalInformationData(userName);
    }

    @RequestMapping("addPersonalInformationData")
    @ResponseBody
    public Integer addPersonalInformationData(PersonalInformationDataEntity personalInformationDataEntity){
        String userName = personalInformationDataEntity.getUserName();
        logBoardManagementDataService.addLogBoard(userName,"执行了增加个人信息的操作","/individual/addPersonalInformationData","暂无备注！");
        return personalInformationDataService.addPersonalInformationData(personalInformationDataEntity);
    }

}
