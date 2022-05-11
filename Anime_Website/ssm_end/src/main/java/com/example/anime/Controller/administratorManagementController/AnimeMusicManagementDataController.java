package com.example.anime.Controller.administratorManagementController;

import com.example.anime.Service.administratorManagementService.AnimeMusicManagementDataService;
import com.example.anime.Service.administratorManagementService.LogBoardManagementDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.anime.Entity.administratorManagementEntity.AnimeMusicManagementDataEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("administrator")
public class AnimeMusicManagementDataController {
    @Autowired
    private AnimeMusicManagementDataService animeMusicManagementDataService;
    @Autowired
    private LogBoardManagementDataService logBoardManagementDataService;

    @RequestMapping("getAnimeMusicData")
    @ResponseBody
    public List<AnimeMusicManagementDataEntity> getAnimeMusicData(){
        return animeMusicManagementDataService.getAnimeMusicData();
    }

    @RequestMapping("getMusicDataByIndex")
    @ResponseBody
    public List<AnimeMusicManagementDataEntity> getMusicDataByIndex(String musicRecommendIndex){
        return animeMusicManagementDataService.getMusicDataByIndex(musicRecommendIndex);
    }

    @RequestMapping("getMusicDataByName")
    @ResponseBody
    public List<AnimeMusicManagementDataEntity> getMusicDataByName(String musicName){
        return animeMusicManagementDataService.getMusicDataByName(musicName);
    }

    @RequestMapping("modifyAnimeMusicData")
    @ResponseBody
    public Integer modifyAnimeMusicData(AnimeMusicManagementDataEntity animeMusicManagementDataEntity){
        return animeMusicManagementDataService.modifyAnimeMusicData(animeMusicManagementDataEntity);
    }

    @RequestMapping("deleteAnimeMusicData")
    @ResponseBody
    public Integer deleteAnimeMusicData(String musicNumber){
        return animeMusicManagementDataService.deleteAnimeMusicData(musicNumber);
    }

    @RequestMapping("addAnimeMusicData")
    @ResponseBody
    public Integer addAnimeMusicData(AnimeMusicManagementDataEntity animeMusicManagementDataEntity){
        return animeMusicManagementDataService.addAnimeMusicData(animeMusicManagementDataEntity);
    }
}
