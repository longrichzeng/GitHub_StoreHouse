package com.example.anime.Dao.individualInformationDataDao;

import com.example.anime.Entity.individualInformationDataEntity.PersonalInformationDataEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface PersonalInformationDataDao {
    /**
     * 根据用户名和用户手机号码获取到用户的个人信息数据
     * @param userName
     * @return
     */
    List<PersonalInformationDataEntity> getPersonalInformationData(@Param("userName")String userName,
                                                                   @Param("location")String location);

    /**
     * 修改用户的个人信息数据
     * @param personalInformationDataEntity
     * @return
     */
    Integer modifyPersonalInformationData(PersonalInformationDataEntity personalInformationDataEntity);

    /**
     * 根据用户名和用户手机号码删除到用户的个人信息数据
     * @param userName
     * @return
     */
    Integer deletePersonalInformationData(@Param("userName")String userName,
                                          @Param("location")String location);

    /**
     * 根据用户名删除该用户所有相关信息
     * @param userName
     * @return
     */
    Integer deleteAllPersonalInformationData(@Param("userName")String userName);

    /**
     * 添加用户的个人信息数据
     * @param personalInformationDataEntity
     * @return
     */
    Integer addPersonalInformationData(PersonalInformationDataEntity personalInformationDataEntity);
}
