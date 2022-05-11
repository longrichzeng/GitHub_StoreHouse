package com.example.anime.Service.administratorManagementService;

import com.example.anime.Entity.userLoginInformationEntity.UserLoginInformationEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface UserInforManagementDataService {
    List<UserLoginInformationEntity> getUserInforData();

    List<UserLoginInformationEntity> getUserInforByUserPermission(String userPermission);

    List<UserLoginInformationEntity> getUserInforByUserName(String name);

    List<UserLoginInformationEntity> getUserInforByPhone(String phone);

    List<UserLoginInformationEntity> getUserInforByEmail(String email);

    Integer modifyUserInforData(UserLoginInformationEntity userLoginInformationEntity);

    Integer deleteUserInforData(String username, String phone);

    Integer addUserInforData(UserLoginInformationEntity userLoginInformationEntity);
}
