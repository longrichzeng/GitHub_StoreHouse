package com.example.anime.Service.administratorManagementService.administratorManagementServiceImpl;

import com.example.anime.Dto.DataGeneratedDailyDTO;
import com.example.anime.Dto.UserLoginInformationDTO;
import com.example.anime.Service.administratorManagementService.DataAnalysisManagementDataService;
import com.example.anime.temporyPackage.Util.GenerateNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.anime.Dao.administratorManagementDao.DataAnalysisManagementDataDao;

import java.util.List;

@Service
public class DataAnalysisManagementDataServiceImpl implements DataAnalysisManagementDataService {
    @Autowired
    private DataAnalysisManagementDataDao dataAnalysisManagementDataDao;

    @Override
    public List<UserLoginInformationDTO> getAnalysisData(){
        return dataAnalysisManagementDataDao.getAnalysisData();
    }

    @Override
    public List<UserLoginInformationDTO> getAnalysisDataBeforeSevenDay(){
        return dataAnalysisManagementDataDao.getAnalysisDataBeforeSevenDay();
    }

    @Override
    public Integer getAnimeDrameDataTotal(){
        return dataAnalysisManagementDataDao.getAnimeDrameDataTotal();
    }

    @Override
    public Integer getAnimeMusicDataTotal(){
        return dataAnalysisManagementDataDao.getAnimeMusicDataTotal();
    }

    @Override
    public Integer getJinpinModelDataTotal(){
        return dataAnalysisManagementDataDao.getJinpinModelDataTotal();
    }

    @Override
    public Integer getNotesDataTotal(){
        return dataAnalysisManagementDataDao.getNotesDataTotal();
    }

    @Override
    public Integer getUserDataTotal(){
        return dataAnalysisManagementDataDao.getUserDataTotal();
    }
    /**********************************************************************************************************************/
    @Override
    public Integer addOneData(DataGeneratedDailyDTO dataGeneratedDailyDTO){
        return dataAnalysisManagementDataDao.addOneData(dataGeneratedDailyDTO);
    }
    /************************************************************************************************************************/
    @Override
    public Integer modifyOneAnimeDrameDataTotal(String dateTime){
        GenerateNumberUtil generateNumberUtil = new GenerateNumberUtil();
        List<DataGeneratedDailyDTO> TempData = dataAnalysisManagementDataDao.getDataByTime(generateNumberUtil.generateTime());
        if(TempData.size() != 0){
            return dataAnalysisManagementDataDao.modifyOneAnimeDrameDataTotal(generateNumberUtil.generateTime());
        }else{
            DataGeneratedDailyDTO dataGeneratedDailyDTO = new DataGeneratedDailyDTO();
            dataGeneratedDailyDTO.setDataId(generateNumberUtil.generateDataNumber());
            dataGeneratedDailyDTO.setDailyLoginOfUsers(0);
            dataGeneratedDailyDTO.setUserDailyRegis(0);
            dataGeneratedDailyDTO.setDailyPurchasesOfJinpin(0);
            dataGeneratedDailyDTO.setDateTime(generateNumberUtil.generateTime());
            dataAnalysisManagementDataDao.addOneData(dataGeneratedDailyDTO);
            return dataAnalysisManagementDataDao.modifyOneAnimeDrameDataTotal(generateNumberUtil.generateTime());
        }
    }

    @Override
    public Integer modifyOneAnimeMusicDataTotal(String dateTime){
        GenerateNumberUtil generateNumberUtil = new GenerateNumberUtil();
        List<DataGeneratedDailyDTO> TempData = dataAnalysisManagementDataDao.getDataByTime(generateNumberUtil.generateTime());
        if(TempData.size() != 0){
            return dataAnalysisManagementDataDao.modifyOneAnimeMusicDataTotal(generateNumberUtil.generateTime());
        }else{
            DataGeneratedDailyDTO dataGeneratedDailyDTO = new DataGeneratedDailyDTO();
            dataGeneratedDailyDTO.setDataId(generateNumberUtil.generateDataNumber());
            dataGeneratedDailyDTO.setDailyLoginOfUsers(0);
            dataGeneratedDailyDTO.setUserDailyRegis(0);
            dataGeneratedDailyDTO.setDailyPurchasesOfJinpin(0);
            dataGeneratedDailyDTO.setDateTime(generateNumberUtil.generateTime());
            dataAnalysisManagementDataDao.addOneData(dataGeneratedDailyDTO);
            return dataAnalysisManagementDataDao.modifyOneAnimeMusicDataTotal(generateNumberUtil.generateTime());
        }
    }

    @Override
    public Integer modifyOneJinpinModelDataTotal(String dateTime){
        GenerateNumberUtil generateNumberUtil = new GenerateNumberUtil();
        List<DataGeneratedDailyDTO> TempData = dataAnalysisManagementDataDao.getDataByTime(generateNumberUtil.generateTime());
        if(TempData.size() != 0){
            return dataAnalysisManagementDataDao.modifyOneJinpinModelDataTotal(generateNumberUtil.generateTime());
        }else{
            DataGeneratedDailyDTO dataGeneratedDailyDTO = new DataGeneratedDailyDTO();
            dataGeneratedDailyDTO.setDataId(generateNumberUtil.generateDataNumber());
            dataGeneratedDailyDTO.setDailyLoginOfUsers(0);
            dataGeneratedDailyDTO.setUserDailyRegis(0);
            dataGeneratedDailyDTO.setDailyPurchasesOfJinpin(0);
            dataGeneratedDailyDTO.setDateTime(generateNumberUtil.generateTime());
            dataAnalysisManagementDataDao.addOneData(dataGeneratedDailyDTO);
            return dataAnalysisManagementDataDao.modifyOneJinpinModelDataTotal(generateNumberUtil.generateTime());
        }
    }

    /************************************************************************************************************************/
    @Override
    public List<DataGeneratedDailyDTO> getDataByTime(String dateTime){
        return dataAnalysisManagementDataDao.getDataByTime(dateTime);
    }
}
