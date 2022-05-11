package com.example.anime.Service.administratorManagementService;

import com.example.anime.Entity.administratorManagementEntity.AnimeDrameManagementDataEntity;
import com.example.anime.Entity.administratorManagementEntity.AnimeMusicManagementDataEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface AnimeMusicManagementDataService {
    List<AnimeMusicManagementDataEntity> getAnimeMusicData();

    List<AnimeMusicManagementDataEntity> getMusicDataByIndex(String musicRecommendIndex);

    List<AnimeMusicManagementDataEntity> getMusicDataByName(String musicName);

    Integer modifyAnimeMusicData(AnimeMusicManagementDataEntity animeMusicManagementDataEntity);

    Integer deleteAnimeMusicData(String musicNumber);

    Integer addAnimeMusicData(AnimeMusicManagementDataEntity animeMusicManagementDataEntity);
}
