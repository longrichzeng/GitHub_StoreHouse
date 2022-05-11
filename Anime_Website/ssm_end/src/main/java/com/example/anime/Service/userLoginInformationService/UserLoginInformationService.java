package com.example.anime.Service.userLoginInformationService;

import com.example.anime.Dto.UserLoginInformationDTO;
import com.example.anime.Entity.userLoginInformationEntity.UserLoginInformationEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface UserLoginInformationService {
    List<UserLoginInformationEntity> loginInfor(String username, String password);

    UserLoginInformationEntity getUserInfor(String username);

    Integer addRegisteredInfor(UserLoginInformationEntity userLoginInformationEntity);

    Integer deleteAllUserLoginInforData(String userName);
}
