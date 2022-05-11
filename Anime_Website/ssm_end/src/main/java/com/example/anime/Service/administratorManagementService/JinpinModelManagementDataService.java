package com.example.anime.Service.administratorManagementService;

import com.example.anime.Entity.administratorManagementEntity.AnimeDrameManagementDataEntity;
import com.example.anime.Entity.administratorManagementEntity.AnimeMusicManagementDataEntity;
import com.example.anime.Entity.administratorManagementEntity.JinpinModelManagementDataEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface JinpinModelManagementDataService {
    List<JinpinModelManagementDataEntity> getJinpinModelData();

    List<JinpinModelManagementDataEntity> getJinpinDataByIndex(String jinPinRecommendIndex);

    List<JinpinModelManagementDataEntity> getJinpinDataByName(String jinPinName);

    Integer modifyJinpinModelData(JinpinModelManagementDataEntity jinpinModelManagementDataEntity);

    Integer deleteJinpinModelData(String jinPinNumber);

    Integer addJinpinModelData(JinpinModelManagementDataEntity jinpinModelManagementDataEntity);
}
