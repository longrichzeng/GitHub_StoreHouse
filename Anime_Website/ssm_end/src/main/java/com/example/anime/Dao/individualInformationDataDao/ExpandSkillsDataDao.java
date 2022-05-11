package com.example.anime.Dao.individualInformationDataDao;

import com.example.anime.Entity.individualInformationDataEntity.ExpandSkillsDataEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface ExpandSkillsDataDao {
    /**
     * 根据用户名和用户手机号码获取到用户的拓展技能数据
     * @param userName
     * @return
     */
    List<ExpandSkillsDataEntity> getExpandSkillsData(@Param("userName")String userName,
                                                     @Param("location")String location);

    /**
     * 修改用户的拓展技能数据
     * @param expandSkillsDataEntity
     * @return
     */
    Integer modifyExpandSkillsData(ExpandSkillsDataEntity expandSkillsDataEntity);

    /**
     * 根据用户名和用户手机号码删除用户的拓展技能数据
     * @param userName
     * @return
     */
    Integer deleteExpandSkillsData(@Param("userName")String userName, @Param("location")String location);

    /**
     * 根据用户名删除该用户所有相关信息
     * @param userName
     * @return
     */
    Integer deleteAllExpandSkillsData(@Param("userName")String userName);

    /**
     * 添加用户的拓展技能数据
     * @param expandSkillsDataEntity
     * @return
     */
    Integer addExpandSkillsData(ExpandSkillsDataEntity expandSkillsDataEntity);
}
