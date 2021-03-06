package com.example.anime.Controller.administratorManagementController;

import com.example.anime.Dao.administratorManagementDao.JinpinModelManagementDataDao;
import com.example.anime.Entity.administratorManagementEntity.AnimeDrameManagementDataEntity;
import com.example.anime.Service.administratorManagementService.JinpinModelManagementDataService;
import com.example.anime.Service.administratorManagementService.LogBoardManagementDataService;
import com.example.anime.temporyPackage.Util.GenerateNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.anime.Entity.administratorManagementEntity.JinpinModelManagementDataEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Controller
@RequestMapping("administrator")
public class JinpinModelManagementDataController {
    @Autowired
    private JinpinModelManagementDataService jinpinModelManagementDataService;
    @Autowired
    private LogBoardManagementDataService logBoardManagementDataService;

    @RequestMapping("getJinpinModelData")
    @ResponseBody
    public List<JinpinModelManagementDataEntity> getJinpinModelData(){
        return jinpinModelManagementDataService.getJinpinModelData();
    }

    @RequestMapping("getJinpinDataByIndex")
    @ResponseBody
    public List<JinpinModelManagementDataEntity> getJinpinDataByIndex(String jinPinRecommendIndex){
        return jinpinModelManagementDataService.getJinpinDataByIndex(jinPinRecommendIndex);
    }

    @RequestMapping("getJinpinDataByName")
    @ResponseBody
    public List<JinpinModelManagementDataEntity> getJinpinDataByName(String jinPinName){
        return jinpinModelManagementDataService.getJinpinDataByName(jinPinName);
    }

    @RequestMapping("modifyJinpinModelData")
    @ResponseBody
    public Integer modifyJinpinModelData(@RequestParam("file") MultipartFile file, JinpinModelManagementDataEntity jinpinModelManagementDataEntity) throws Exception {
        //???????????????????????????animeNumber
        String jinPinNumber = jinpinModelManagementDataEntity.getJinPinNumber();
        //?????????????????????anime??????????????????
        String imagePath = "F:\\Anime_Website\\vue_front\\src\\assets\\jinpinImage\\" + jinPinNumber + ".png";
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
            return jinpinModelManagementDataService.modifyJinpinModelData(jinpinModelManagementDataEntity);
        } else {
            return jinpinModelManagementDataService.modifyJinpinModelData(jinpinModelManagementDataEntity);
        }
    }

    @RequestMapping("deleteJinpinModelData")
    @ResponseBody
    public Integer deleteJinpinModelData(String jinPinNumber){
        return jinpinModelManagementDataService.deleteJinpinModelData(jinPinNumber);
    }

    @RequestMapping("addJinpinModelData")
    @ResponseBody
    public Integer addJinpinModelData(@RequestParam("file") MultipartFile file, JinpinModelManagementDataEntity jinpinModelManagementDataEntity) throws Exception{
        GenerateNumberUtil generateNumberUtil = new GenerateNumberUtil();

        String jinpinNumber = generateNumberUtil.generateJinpinNumber();
        String jinpinImageUrl = "F:\\Anime_Website\\vue_front\\src\\assets\\jinpinImage\\" + jinpinNumber + ".png";

        if (file != null){
            System.out.println("????????????");
            File destFile = new File(jinpinImageUrl);
            file.transferTo(destFile);

            jinpinModelManagementDataEntity.setJinPinNumber(jinpinNumber);
            return jinpinModelManagementDataService.addJinpinModelData(jinpinModelManagementDataEntity);
        }else{
            System.out.println("????????????");
        }
        return jinpinModelManagementDataService.addJinpinModelData(null);
    }

}
