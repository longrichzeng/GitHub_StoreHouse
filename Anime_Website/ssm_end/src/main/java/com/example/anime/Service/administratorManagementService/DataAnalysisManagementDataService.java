package com.example.anime.Service.administratorManagementService;

import com.example.anime.Dto.DataGeneratedDailyDTO;
import com.example.anime.Dto.UserLoginInformationDTO;
import com.example.anime.Entity.administratorManagementEntity.AnimeDrameManagementDataEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface DataAnalysisManagementDataService {
    List<UserLoginInformationDTO> getAnalysisData();

    List<UserLoginInformationDTO> getAnalysisDataBeforeSevenDay();

    Integer getAnimeDrameDataTotal();

    Integer getAnimeMusicDataTotal();

    Integer getJinpinModelDataTotal();

    Integer getNotesDataTotal();

    Integer getUserDataTotal();
/**********************************************************************************************************************/
    Integer addOneData(DataGeneratedDailyDTO dataGeneratedDailyDTO);
/************************************************************************************************************************/
    Integer modifyOneAnimeDrameDataTotal(String dateTime);

    Integer modifyOneAnimeMusicDataTotal(String dateTime);

    Integer modifyOneJinpinModelDataTotal(String dateTime);
    /************************************************************************************************************************/
    List<DataGeneratedDailyDTO> getDataByTime(String dateTime);
}
