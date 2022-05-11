package com.example.anime.Dao.administratorManagementDao;

import com.example.anime.Entity.administratorManagementEntity.AnimeMusicManagementDataEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface AnimeMusicManagementDataDao {
    /**
     * 获取AnimeMusic对应数据表的所有数据
     * @return
     */
    List<AnimeMusicManagementDataEntity> getAnimeMusicData();

    /**
     * 修改AnimeMusic对应数据表的数据
     * @param animeMusicManagementDataEntity
     * @return
     */
    Integer modifyAnimeMusicData(AnimeMusicManagementDataEntity animeMusicManagementDataEntity);

    /**
     * 通过音乐指数获得对应信息
     * @param musicRecommendIndex
     * @return
     */
    List<AnimeMusicManagementDataEntity> getMusicDataByIndex(@Param("musicRecommendIndex")String musicRecommendIndex);

    /**
     * 通过音乐名称获得对应信息
     * @param musicName
     * @return
     */
    List<AnimeMusicManagementDataEntity> getMusicDataByName(@Param("musicName")String musicName);

    /**
     * 根据musicNumber删除AnimeMusic对应的数据
     * @param musicNumber
     * @return
     */
    Integer deleteAnimeMusicData(@Param("musicNumber")String musicNumber);

    /**
     * 向AnimeMusic数据表添加新的数据
     * @param animeMusicManagementDataEntity
     * @return
     */
    Integer addAnimeMusicData(AnimeMusicManagementDataEntity animeMusicManagementDataEntity);
}
