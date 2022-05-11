package com.example.anime.Service.administratorManagementService.administratorManagementServiceImpl;

import com.example.anime.Entity.userLoginInformationEntity.UserLoginInformationEntity;
import com.example.anime.Service.administratorManagementService.UserInforManagementDataService;
import com.example.anime.temporyPackage.Constants.ShiroConstant;
import com.example.anime.temporyPackage.Util.SaltGenerateUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.anime.Dao.administratorManagementDao.UserInforManagementDataDao;

import java.util.List;

@Service
public class UserInforManagementDataServiceImpl implements UserInforManagementDataService {
    @Autowired
    private UserInforManagementDataDao userInforManagementDataDao;

    @Override
    public List<UserLoginInformationEntity> getUserInforData(){
        return userInforManagementDataDao.getUserInforData();
    }

    @Override
    public List<UserLoginInformationEntity> getUserInforByUserPermission(String userPermission){
        return userInforManagementDataDao.getUserInforByUserPermission(userPermission);
    }

    @Override
    public List<UserLoginInformationEntity> getUserInforByUserName(String name){
        return userInforManagementDataDao.getUserInforByUserName(name);
    }

    @Override
    public List<UserLoginInformationEntity> getUserInforByPhone(String phone){
        return userInforManagementDataDao.getUserInforByPhone(phone);
    }

    @Override
    public List<UserLoginInformationEntity> getUserInforByEmail(String email){
        return userInforManagementDataDao.getUserInforByEmail(email);
    }

    @Override
    public Integer modifyUserInforData(UserLoginInformationEntity userLoginInformationEntity){
        String tempPassword = userLoginInformationEntity.getPassword();
        String salt = SaltGenerateUtil.GenerateSalt(ShiroConstant.SALT_LENGTH);
        Md5Hash password = new Md5Hash(tempPassword, salt, ShiroConstant.HASH_ITERATORS);
        userLoginInformationEntity.setSalt(salt);
        userLoginInformationEntity.setPassword(password.toHex());
        return userInforManagementDataDao.modifyUserInforData(userLoginInformationEntity);
    }

    @Override
    public Integer deleteUserInforData(String username, String phone){
        return userInforManagementDataDao.deleteUserInforData(username, phone);
    }

    @Override
    public Integer addUserInforData(UserLoginInformationEntity userLoginInformationEntity){
        String username = userLoginInformationEntity.getUsername();
        String tempPassword = userLoginInformationEntity.getPassword();
        String name = userLoginInformationEntity.getName();
        String phone = userLoginInformationEntity.getPhone();
        String email = userLoginInformationEntity.getEmail();
        String userPermission = userLoginInformationEntity.getUserPermission();
        if(username != null && tempPassword != null && name != null && phone != null && email != null && userPermission != null){
            String salt = SaltGenerateUtil.GenerateSalt(ShiroConstant.SALT_LENGTH);
            Md5Hash password = new Md5Hash(tempPassword, salt, ShiroConstant.HASH_ITERATORS);
            userLoginInformationEntity.setSalt(salt);
            userLoginInformationEntity.setPassword(password.toHex());
            return userInforManagementDataDao.addUserInforData(userLoginInformationEntity);
        }else{
            return userInforManagementDataDao.addUserInforData(null);
        }
    }
}




