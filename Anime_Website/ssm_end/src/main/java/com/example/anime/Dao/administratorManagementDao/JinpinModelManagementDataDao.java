package com.example.anime.Dao.administratorManagementDao;

import com.example.anime.Entity.administratorManagementEntity.AnimeMusicManagementDataEntity;
import com.example.anime.Entity.administratorManagementEntity.JinpinModelManagementDataEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface JinpinModelManagementDataDao {
    /**
     * 获取JinpinModel对应数据表的所有数据
     * @return
     */
    List<JinpinModelManagementDataEntity> getJinpinModelData();

    /**
     * 通过推荐指数获得对应信息
     * @param jinPinRecommendIndex
     * @return
     */
    List<JinpinModelManagementDataEntity> getJinpinDataByIndex(@Param("jinPinRecommendIndex")String jinPinRecommendIndex);

    /**
     * 通过景品名称获得对应信息
     * @param jinPinName
     * @return
     */
    List<JinpinModelManagementDataEntity> getJinpinDataByName(@Param("jinPinName")String jinPinName);

    /**
     * 修改JinpinModel对应数据表的数据
     * @param jinpinModelManagementDataEntity
     * @return
     */
    Integer modifyJinpinModelData(JinpinModelManagementDataEntity jinpinModelManagementDataEntity);

    /**
     * 根据animeNumber删除JinpinModel对应的数据
     * @param jinPinNumber
     * @return
     */
    Integer deleteJinpinModelData(@Param("jinPinNumber")String jinPinNumber);

    /**
     * 向JinpinModel数据表添加新的数据
     * @param jinpinModelManagementDataEntity
     * @return
     */
    Integer addJinpinModelData(JinpinModelManagementDataEntity jinpinModelManagementDataEntity);
}
