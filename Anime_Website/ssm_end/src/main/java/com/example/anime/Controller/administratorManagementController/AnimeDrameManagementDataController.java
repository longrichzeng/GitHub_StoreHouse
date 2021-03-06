package com.example.anime.Controller.administratorManagementController;

import com.example.anime.Entity.administratorManagementEntity.AnimeDrameManagementDataEntity;
import com.example.anime.Service.administratorManagementService.AnimeDrameManagementDataService;
import com.example.anime.Service.administratorManagementService.LogBoardManagementDataService;
import com.example.anime.temporyPackage.Util.GenerateNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Controller
@RequestMapping("administrator")
public class AnimeDrameManagementDataController {
    @Autowired
    private AnimeDrameManagementDataService animeDrameManagementDataService;
    @Autowired
    private LogBoardManagementDataService logBoardManagementDataService;

    @RequestMapping("getAnimeDrameData")
    @ResponseBody
    public List<AnimeDrameManagementDataEntity> getAnimeDrameData(){
        return animeDrameManagementDataService.getAnimeDrameData();
    }

    @RequestMapping("getAnimeAboutType")
    @ResponseBody
    public List<AnimeDrameManagementDataEntity> getAnimeAboutType(String animeType){
        return animeDrameManagementDataService.getAnimeAboutType(animeType);
    }

    @RequestMapping("getAnimeAboutIndex")
    @ResponseBody
    public List<AnimeDrameManagementDataEntity> getAnimeAboutIndex(String animeRecommendIndex){
        return animeDrameManagementDataService.getAnimeAboutIndex(animeRecommendIndex);
    }

    @RequestMapping("getAnimeAboutName")
    @ResponseBody
    public List<AnimeDrameManagementDataEntity> getAnimeAboutName(String animeName){
        return animeDrameManagementDataService.getAnimeAboutName(animeName);
    }

    @RequestMapping("modifyAnimeDrameData")
    @ResponseBody
    public Integer modifyAnimeDrameData(@RequestParam("file") MultipartFile file, AnimeDrameManagementDataEntity animeDrameManagementDataEntity) throws Exception {
        //???????????????????????????animeNumber
        String animeNumber = animeDrameManagementDataEntity.getAnimeNumber();
        //?????????????????????anime??????????????????
        String imagePath = "F:\\Anime_Website\\vue_front\\src\\assets\\animeImage\\" + animeNumber + ".png";
        //???????????????File??????,?????????????????????????????????
        File existeFile = new File(imagePath);
        //????????????????????????????????????????????????????????????????????????????????????
        if (file != null) {
            //?????????????????????(animeNumber?????????)??????????????????,?????????????????????,???????????????????????????,????????????????????????????????????,
            //????????????????????????????????????????????????
            if (!existeFile.exists()) {
                System.out.println("?????????????????????" + imagePath + "????????????");
                File destFile = new File(imagePath);
                file.transferTo(destFile);
            } else {
                existeFile.delete();
                System.out.println("??????????????????????????????");
                File destFile = new File(imagePath);
                file.transferTo(destFile);
            }
            return animeDrameManagementDataService.modifyAnimeDrameData(animeDrameManagementDataEntity);
        } else {
            return animeDrameManagementDataService.modifyAnimeDrameData(animeDrameManagementDataEntity);
        }
    }

    @RequestMapping("deleteAnimeDrameData")
    @ResponseBody
    public Integer deleteAnimeDrameData(String animeNumber){
        return animeDrameManagementDataService.deleteAnimeDrameData(animeNumber);
    }

    @RequestMapping("addAnimeDrameData")
    @ResponseBody
    public Integer addAnimeDrameData(@RequestParam("file") MultipartFile file, AnimeDrameManagementDataEntity animeDrameManagementDataEntity) throws Exception{
        GenerateNumberUtil generateNumberUtil = new GenerateNumberUtil();

        String animeNumber = generateNumberUtil.generateAnimeDrameNumber();
        String animeImageUrl = "F:\\Anime_Website\\vue_front\\src\\assets\\animeImage\\" + animeNumber + ".png";

        if (file != null){
            System.out.println("????????????");
            File destFile = new File(animeImageUrl);
            file.transferTo(destFile);

            animeDrameManagementDataEntity.setAnimeNumber(animeNumber);
            return animeDrameManagementDataService.addAnimeDrameData(animeDrameManagementDataEntity);
        }else{
            System.out.println("????????????");
        }
        return animeDrameManagementDataService.addAnimeDrameData(null);
    }
}
