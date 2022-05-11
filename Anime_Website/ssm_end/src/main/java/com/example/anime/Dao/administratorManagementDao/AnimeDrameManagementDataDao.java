package com.example.anime.Dao.administratorManagementDao;


import com.example.anime.Entity.administratorManagementEntity.AnimeDrameManagementDataEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface AnimeDrameManagementDataDao {
    /**
     * 获取AnimeDrame对应数据表的所有数据
     * @return
     */
    List<AnimeDrameManagementDataEntity> getAnimeDrameData();

    /**
     * 根据动漫类型查找对应动漫
     * @return
     */
    List<AnimeDrameManagementDataEntity> getAnimeAboutType(@Param("animeType")String animeType);

    /**
     * 根据动漫推荐指数查找对应动漫
     * @return
     */
    List<AnimeDrameManagementDataEntity> getAnimeAboutIndex(@Param("animeRecommendIndex")String animeRecommendIndex);

    /**
     * 根据动漫名称查找对应动漫
     * @return
     */
    List<AnimeDrameManagementDataEntity> getAnimeAboutName(@Param("animeName")String animeName);

    /**
     * 修改AnimeDrame对应数据表的数据
     * @param animeDrameManagementDataEntity
     * @return
     */
    Integer modifyAnimeDrameData(AnimeDrameManagementDataEntity animeDrameManagementDataEntity);

    /**
     * 根据animeNumber删除AnimeDrame对应的数据
     * @param animeNumber
     * @return
     */
    Integer deleteAnimeDrameData(@Param("animeNumber")String animeNumber);

    /**
     * 向AnimeDrame数据表添加新的数据
     * @param animeDrameManagementDataEntity
     * @return
     */
    Integer addAnimeDrameData(AnimeDrameManagementDataEntity animeDrameManagementDataEntity);
}
