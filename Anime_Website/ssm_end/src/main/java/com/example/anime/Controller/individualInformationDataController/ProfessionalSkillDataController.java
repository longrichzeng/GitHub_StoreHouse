package com.example.anime.Controller.individualInformationDataController;

import com.example.anime.Entity.individualInformationDataEntity.ProfessionalSkillDataEntity;
import com.example.anime.Service.administratorManagementService.LogBoardManagementDataService;
import com.example.anime.temporyPackage.Util.LogPreserveUtil;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.anime.Service.individualInformationDataService.ProfessionalSkillDataService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("individual")
public class ProfessionalSkillDataController {
    @Autowired
    private ProfessionalSkillDataService professionalSkillDataService;
    @Autowired
    private LogBoardManagementDataService logBoardManagementDataService;

    @RequestMapping("getProfessionalSkillData")
    @ResponseBody
    public List<ProfessionalSkillDataEntity> getProfessionalSkillData(String userName, String location){
        logBoardManagementDataService.addLogBoard(userName,"执行了获取专业技能的操作","/individual/getProfessionalSkillData","暂无备注！");
        return professionalSkillDataService.getProfessionalSkillData(userName, location);
    }

    @RequestMapping("modifyProfessionalSkillData")
    @ResponseBody
    public Integer modifyProfessionalSkillData(ProfessionalSkillDataEntity professionalSkillDataEntity){
        String userName = professionalSkillDataEntity.getUserName();
        logBoardManagementDataService.addLogBoard(userName,"执行了修改专业技能的操作","/individual/modifyProfessionalSkillData","暂无备注！");
        return professionalSkillDataService.modifyProfessionalSkillData(professionalSkillDataEntity);
    }

    @RequestMapping("deleteProfessionalSkillData")
    @ResponseBody
    public Integer deleteProfessionalSkillData(String userName, String location){
        logBoardManagementDataService.addLogBoard(userName,"执行了删除专业技能的操作","/individual/deleteProfessionalSkillData","暂无备注！");
        return professionalSkillDataService.deleteProfessionalSkillData(userName, location);
    }

    @RequestMapping("deleteAllProfessionalSkillData")
    @ResponseBody
    public Integer deleteAllProfessionalSkillData(String userName){
        logBoardManagementDataService.addLogBoard(userName,"执行了删除所有专业技能的操作","/individual/deleteAllProfessionalSkillData","暂无备注！");
        return professionalSkillDataService.deleteAllProfessionalSkillData(userName);
    }

    @RequestMapping("addProfessionalSkillData")
    @ResponseBody
    public Integer addProfessionalSkillData(ProfessionalSkillDataEntity professionalSkillDataEntity){
        String userName = professionalSkillDataEntity.getUserName();
        logBoardManagementDataService.addLogBoard(userName,"执行了添加专业技能的操作","/individual/addProfessionalSkillData","暂无备注！");
        return professionalSkillDataService.addProfessionalSkillData(professionalSkillDataEntity);
    }

}
