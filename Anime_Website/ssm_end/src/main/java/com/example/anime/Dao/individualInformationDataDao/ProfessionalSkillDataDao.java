package com.example.anime.Dao.individualInformationDataDao;

import com.example.anime.Entity.individualInformationDataEntity.ProfessionalSkillDataEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface ProfessionalSkillDataDao {
    /**
     * 根据用户名和用户手机号码获取到用户的专业技能数据
     * @param userName
     * @return
     */
    List<ProfessionalSkillDataEntity> getProfessionalSkillData(@Param("userName")String userName,
                                                               @Param("location")String location);

    /**
     * 修改用户的专业技能数据
     * @param professionalSkillDataEntity
     * @return
     */
    Integer modifyProfessionalSkillData(ProfessionalSkillDataEntity professionalSkillDataEntity);

    /**
     * 根据用户名和用户手机号码删除用户的专业技能数据
     * @param userName
     * @return
     */
    Integer deleteProfessionalSkillData(@Param("userName")String userName,
                                        @Param("location")String location);

    /**
     * 根据用户名删除该用户所有相关信息
     * @param userName
     * @return
     */
    Integer deleteAllProfessionalSkillData(@Param("userName")String userName);

    /**
     * 添加用户的专业技能数据
     * @param professionalSkillDataEntity
     * @return
     */
    Integer addProfessionalSkillData(ProfessionalSkillDataEntity professionalSkillDataEntity);
}
