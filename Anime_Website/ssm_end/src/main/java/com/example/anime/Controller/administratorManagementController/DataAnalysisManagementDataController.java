package com.example.anime.Controller.administratorManagementController;

import com.example.anime.Dao.administratorManagementDao.DataAnalysisManagementDataDao;
import com.example.anime.Dto.DataGeneratedDailyDTO;
import com.example.anime.Dto.ShoppingCartInformationDTO;
import com.example.anime.Dto.UserLoginInformationDTO;
import com.example.anime.Service.administratorManagementService.DataAnalysisManagementDataService;
import com.example.anime.Service.administratorManagementService.LogBoardManagementDataService;
import com.example.anime.temporyPackage.Util.GenerateNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.anime.Entity.administratorManagementEntity.DataAnalysisManagementDataEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("administrator")
public class DataAnalysisManagementDataController {
    @Autowired
    private DataAnalysisManagementDataService dataAnalysisManagementDataService;
    @Autowired
    private LogBoardManagementDataService logBoardManagementDataService;

    @RequestMapping("getAnalysisData")
    @ResponseBody
    public List<UserLoginInformationDTO> getAnalysisData(){
        return dataAnalysisManagementDataService.getAnalysisData();
    }

    @RequestMapping("getAnalysisDataBeforeSevenDay")
    @ResponseBody
    public List<UserLoginInformationDTO> getAnalysisDataBeforeSevenDay(){
        return dataAnalysisManagementDataService.getAnalysisDataBeforeSevenDay();
    }

    @RequestMapping("getTotalData")
    @ResponseBody
    public List getAnimeDrameDataTotal(){
        int firstTotal = dataAnalysisManagementDataService.getAnimeDrameDataTotal();
        int secondTotal = dataAnalysisManagementDataService.getAnimeMusicDataTotal();
        int thirtTotal = dataAnalysisManagementDataService.getJinpinModelDataTotal();
        int fourthTotal = dataAnalysisManagementDataService.getNotesDataTotal();
        int fifthTotal = dataAnalysisManagementDataService.getUserDataTotal();
        List data = new ArrayList();
        data.add(0,fifthTotal);
        data.add(0,fourthTotal);
        data.add(0,thirtTotal);
        data.add(0,secondTotal);
        data.add(0,firstTotal);
        return data;
    }

//    @RequestMapping("getAnimeDrameDataTotal")
//    @ResponseBody
//    public Integer getAnimeDrameDataTotal(){
//        Integer total = dataAnalysisManagementDataService.getAnimeDrameDataTotal();
//        return total;
//    }
//
//    @RequestMapping("getAnimeMusicDataTotal")
//    @ResponseBody
//    public Integer getAnimeMusicDataTotal(){
//        int total = dataAnalysisManagementDataService.getAnimeMusicDataTotal();
//        return total;
//    }
//
//    @RequestMapping("getJinpinModelDataTotal")
//    @ResponseBody
//    public Integer getJinpinModelDataTotal(){
//        int total = dataAnalysisManagementDataService.getJinpinModelDataTotal();
//        return total;
//    }
//
//    @RequestMapping("getNotesDataTotal")
//    @ResponseBody
//    public Integer getNotesDataTotal(){
//        int total = dataAnalysisManagementDataService.getNotesDataTotal();
//        return total;
//    }
//
//    @RequestMapping("getUserDataTotal")
//    @ResponseBody
//    public Integer getUserDataTotal(){
//        int total = dataAnalysisManagementDataService.getUserDataTotal();
//        return total;
//    }
    /**********************************************************************************************************************/

//    @RequestMapping("addOneData")
//    @ResponseBody
//    public Integer addOneData(DataGeneratedDailyDTO dataGeneratedDailyDTO){
//        return dataAnalysisManagementDataService.addOneData(dataGeneratedDailyDTO);
//    }
    /************************************************************************************************************************/
//
//    @RequestMapping("modifyOneAnimeDrameDataTotal")
//    @ResponseBody
//    public Integer modifyOneAnimeDrameDataTotal(){
//        GenerateNumberUtil generateNumberUtil = new GenerateNumberUtil();
//        List<DataGeneratedDailyDTO> TempData = dataAnalysisManagementDataService.getDataByTime(generateNumberUtil.generateTime());
//        if(TempData.size() != 0){
//            return dataAnalysisManagementDataService.modifyOneAnimeDrameDataTotal(generateNumberUtil.generateTime());
//        }else{
//            DataGeneratedDailyDTO dataGeneratedDailyDTO = new DataGeneratedDailyDTO();
//            dataGeneratedDailyDTO.setDataId(generateNumberUtil.generateDataNumber());
//            dataGeneratedDailyDTO.setDailyLoginOfUsers(0);
//            dataGeneratedDailyDTO.setUserDailyRegis(0);
//            dataGeneratedDailyDTO.setDailyPurchasesOfJinpin(0);
//            dataGeneratedDailyDTO.setDateTime(generateNumberUtil.generateTime());
//            dataAnalysisManagementDataService.addOneData(dataGeneratedDailyDTO);
//            return dataAnalysisManagementDataService.modifyOneAnimeDrameDataTotal(generateNumberUtil.generateTime());
//        }
//    }

//    @RequestMapping("modifyOneAnimeMusicDataTotal")
//    @ResponseBody
//    public Integer modifyOneAnimeMusicDataTotal(){
//        GenerateNumberUtil generateNumberUtil = new GenerateNumberUtil();
//        List<DataGeneratedDailyDTO> TempData = dataAnalysisManagementDataService.getDataByTime(generateNumberUtil.generateTime());
//        if(TempData.size() != 0){
//            return dataAnalysisManagementDataService.modifyOneAnimeMusicDataTotal(generateNumberUtil.generateTime());
//        }else{
//            DataGeneratedDailyDTO dataGeneratedDailyDTO = new DataGeneratedDailyDTO();
//            dataGeneratedDailyDTO.setDataId(generateNumberUtil.generateDataNumber());
//            dataGeneratedDailyDTO.setDailyLoginOfUsers(0);
//            dataGeneratedDailyDTO.setUserDailyRegis(0);
//            dataGeneratedDailyDTO.setDailyPurchasesOfJinpin(0);
//            dataGeneratedDailyDTO.setDateTime(generateNumberUtil.generateTime());
//            dataAnalysisManagementDataService.addOneData(dataGeneratedDailyDTO);
//            return dataAnalysisManagementDataService.modifyOneAnimeMusicDataTotal(generateNumberUtil.generateTime());
//        }
//    }
//
//    @RequestMapping("modifyOneJinpinModelDataTotal")
//    @ResponseBody
//    public Integer modifyOneJinpinModelDataTotal(){
//        GenerateNumberUtil generateNumberUtil = new GenerateNumberUtil();
//        List<DataGeneratedDailyDTO> TempData = dataAnalysisManagementDataService.getDataByTime(generateNumberUtil.generateTime());
//        if(TempData.size() != 0){
//            return dataAnalysisManagementDataService.modifyOneJinpinModelDataTotal(generateNumberUtil.generateTime());
//        }else{
//            DataGeneratedDailyDTO dataGeneratedDailyDTO = new DataGeneratedDailyDTO();
//            dataGeneratedDailyDTO.setDataId(generateNumberUtil.generateDataNumber());
//            dataGeneratedDailyDTO.setDailyLoginOfUsers(0);
//            dataGeneratedDailyDTO.setUserDailyRegis(0);
//            dataGeneratedDailyDTO.setDailyPurchasesOfJinpin(0);
//            dataGeneratedDailyDTO.setDateTime(generateNumberUtil.generateTime());
//            dataAnalysisManagementDataService.addOneData(dataGeneratedDailyDTO);
//            return dataAnalysisManagementDataService.modifyOneJinpinModelDataTotal(generateNumberUtil.generateTime());
//        }
//    }
    /************************************************************************************************************************/

    @RequestMapping("getDataByTime")
    @ResponseBody
    public List<DataGeneratedDailyDTO> getDataByTime(String dateTime){
        return dataAnalysisManagementDataService.getDataByTime(dateTime);
    }
}
