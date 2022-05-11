package com.example.anime.Dao.administratorManagementDao;

import com.example.anime.Entity.userLoginInformationEntity.UserLoginInformationEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface UserInforManagementDataDao {
    /**
     * 获取到所有的用户数据
     * @return
     */
    List<UserLoginInformationEntity> getUserInforData();

    /**
     * 通过权限获取到所有的用户数据
     * @return
     */
    List<UserLoginInformationEntity> getUserInforByUserPermission(@Param("userPermission")String userPermission);

    /**
     * 通过用户名获取到所有的用户数据
     * @return
     */
    List<UserLoginInformationEntity> getUserInforByUserName(@Param("name")String name);

    /**
     * 通过手机号码获取到所有的用户数据
     * @return
     */
    List<UserLoginInformationEntity> getUserInforByPhone(@Param("phone")String phone);

    /**
     * 通过邮箱获取到所有的用户数据
     * @return
     */
    List<UserLoginInformationEntity> getUserInforByEmail(@Param("email")String email);

    /**
     * 修改用户表的部分数据
     * @param userLoginInformationEntity
     * @return
     */
    Integer modifyUserInforData(UserLoginInformationEntity userLoginInformationEntity);

    /**
     * 根据用户名和手机号码把对应的用户删除
     * @param username
     * @param phone
     * @return
     */
    Integer deleteUserInforData(@Param("username")String username, @Param("phone")String phone);

    /**
     * 用戶管理者增加新用戶的信息接口
     * @param userLoginInformationEntity
     * @return
     */
    Integer addUserInforData(UserLoginInformationEntity userLoginInformationEntity);
}
