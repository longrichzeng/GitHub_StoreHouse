package com.example.anime.Service.userLoginInformationService.userLoginInformationServiceImpl;

import com.example.anime.Dto.UserLoginInformationDTO;
import com.example.anime.Entity.userLoginInformationEntity.UserLoginInformationEntity;
import com.example.anime.Service.userLoginInformationService.UserLoginInformationService;
import com.example.anime.temporyPackage.Constants.ShiroConstant;
import com.example.anime.temporyPackage.Util.SaltGenerateUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.anime.Dao.userLoginInformationDao.UserLoginInformationDao;

import java.util.List;

@Service("userLoginInformationService")
public class UserLoginInformationServiceImpl implements UserLoginInformationService {
    @Autowired
    private UserLoginInformationDao userLoginInformationDao;

    @Override
    public List<UserLoginInformationEntity> loginInfor(String username, String password){
        return userLoginInformationDao.loginInfor(username, password);
    }

    @Override
    public UserLoginInformationEntity getUserInfor(String username){
        return userLoginInformationDao.getUserInfor(username);
    }

    @Override
    public Integer addRegisteredInfor(UserLoginInformationEntity userLoginInformationEntity){
        String username = userLoginInformationEntity.getUsername();
        String tempPassword = userLoginInformationEntity.getPassword();
        String name = userLoginInformationEntity.getName();
        String phone = userLoginInformationEntity.getPhone();
        String email = userLoginInformationEntity.getEmail();
        if(username != null && tempPassword != null && name != null && phone != null && email != null) {
            String salt = SaltGenerateUtil.GenerateSalt(ShiroConstant.SALT_LENGTH);
            Md5Hash password = new Md5Hash(tempPassword, salt, ShiroConstant.HASH_ITERATORS);
            userLoginInformationEntity.setSalt(salt);
            userLoginInformationEntity.setPassword(password.toHex());
            userLoginInformationEntity.setUserPermission("GeneralUser");
            return userLoginInformationDao.addRegisteredInfor(userLoginInformationEntity);
        }else{
            return userLoginInformationDao.addRegisteredInfor(null);
        }
    }


    @Override
    public Integer deleteAllUserLoginInforData(String userName){
        return userLoginInformationDao.deleteAllUserLoginInforData(userName);
    }
}
