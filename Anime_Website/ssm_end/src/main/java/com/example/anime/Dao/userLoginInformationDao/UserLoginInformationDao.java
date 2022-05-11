package com.example.anime.Dao.userLoginInformationDao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.anime.Dto.UserLoginInformationDTO;
import io.lettuce.core.dynamic.annotation.Param;
import com.example.anime.Entity.userLoginInformationEntity.UserLoginInformationEntity;

import java.util.List;

public interface UserLoginInformationDao {
    /**
     * 根据从前端获取到的用户名和对应的密码，去数据库查找对应的用户信息
     * @param username
     * @param password
     * @return
     */
    List<UserLoginInformationEntity> loginInfor(@Param("username")String username, @Param("password")String password);

    /**
     * 根据用户名和手机获取登陆后的用户信息
     * @param username
     * @return
     */
    UserLoginInformationEntity getUserInfor(@Param("username")String username);

    /**
     * 提交新用户的注册信息
     * @param userLoginInformationEntity
     * @return
     */
    Integer addRegisteredInfor(UserLoginInformationEntity userLoginInformationEntity);

    /**
     * 根据用户名删除该用户所有相关信息
     * @param userName
     * @return
     */
    Integer deleteAllUserLoginInforData(@Param("userName")String userName);

}
