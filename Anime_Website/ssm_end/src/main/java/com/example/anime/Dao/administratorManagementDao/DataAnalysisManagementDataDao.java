package com.example.anime.Dao.administratorManagementDao;

import com.example.anime.Dto.DataGeneratedDailyDTO;
import com.example.anime.Dto.UserLoginInformationDTO;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface DataAnalysisManagementDataDao {
    /**
     * 获取到所有的图表数据
     * @return
     */
    List<UserLoginInformationDTO> getAnalysisData();

    /**
     * 获取到七天前的图表数据
     * @return
     */
    List<UserLoginInformationDTO> getAnalysisDataBeforeSevenDay();

    /**
     * 获取到动漫番剧的总数
     * @return
     */
    Integer getAnimeDrameDataTotal();

    /**
     * 获取到动漫音乐的总数
     * @return
     */
    Integer getAnimeMusicDataTotal();

    /**
     * 获取到景品手办的总数
     * @return
     */
    Integer getJinpinModelDataTotal();

    /**
     * 获取到笔记的总数
     * @return
     */
    Integer getNotesDataTotal();

    /**
     * 获取到用户的总数
     * @return
     */
    Integer getUserDataTotal();
/**********************************************************************************************************************/
/**********************************************************************************************************************/
    //在用户日注册量、用户日登录量、景品日购买量这个三个数据中，新增都是独立的，并且都得先判定时间是否为当天，
    //所需要定义的方法有自增方法三个、删除方法一个、获取所有总量一个。
    /**
     * 添加用户日注册量
     */
    Integer addOneData(DataGeneratedDailyDTO dataGeneratedDailyDTO);
/************************************************************************************************************************/
    /**
     * 根据时间来自增用户日注册量
     */
    Integer modifyOneAnimeDrameDataTotal(@Param("dateTime")String dateTime);

    /**
     * 根据时间来自增用户日登录量
     */
    Integer modifyOneAnimeMusicDataTotal(@Param("dateTime")String dateTime);

    /**
     * 根据时间来自增景品日购买量
     */
    Integer modifyOneJinpinModelDataTotal(@Param("dateTime")String dateTime);
/************************************************************************************************************************/

    List<DataGeneratedDailyDTO> getDataByTime(@Param("dateTime")String dateTime);

}
