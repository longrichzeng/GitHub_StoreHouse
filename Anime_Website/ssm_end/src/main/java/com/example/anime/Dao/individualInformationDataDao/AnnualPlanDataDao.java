package com.example.anime.Dao.individualInformationDataDao;

import com.example.anime.Entity.individualInformationDataEntity.AnnualPlanDataEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface AnnualPlanDataDao {
    /**
     * 根据用户名和用户手机号码获取到用户的年度计划数据
     * @param userName
     * @return
     */
    List<AnnualPlanDataEntity> getAnnualPlanData(@Param("userName")String userName);

    /**
     * 修改用户的年度计划数据
     * @param annualPlanDataEntity
     * @return
     */
    Integer modifyAnnualPlanData(AnnualPlanDataEntity annualPlanDataEntity);

    /**
     * 根据用户名和用户手机号码删除用户的年度计划数据
     * @param userName
     * @return
     */
    Integer deleteAnnualPlanData(@Param("userName")String userName, @Param("location")String location);

    /**
     * 根据用户名删除该用户所有相关信息
     * @param userName
     * @return
     */
    Integer deleteAllAnnualPlanData(@Param("userName")String userName);

    /**
     * 添加用户的年度计划的数据
     * @param annualPlanDataEntity
     * @return
     */
    Integer addAnnualPlanData(AnnualPlanDataEntity annualPlanDataEntity);

}
