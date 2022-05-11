package com.example.anime.Service.administratorManagementService;

import com.example.anime.Entity.administratorManagementEntity.AnimeDrameManagementDataEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface AnimeDrameManagementDataService {
    List<AnimeDrameManagementDataEntity> getAnimeDrameData();

    List<AnimeDrameManagementDataEntity> getAnimeAboutType(String animeType);

    List<AnimeDrameManagementDataEntity> getAnimeAboutIndex(String animeRecommendIndex);

    List<AnimeDrameManagementDataEntity> getAnimeAboutName(String animeName);

    Integer modifyAnimeDrameData(AnimeDrameManagementDataEntity animeDrameManagementDataEntity);

    Integer deleteAnimeDrameData(String animeNumber);

    Integer addAnimeDrameData(AnimeDrameManagementDataEntity animeDrameManagementDataEntity);
}
