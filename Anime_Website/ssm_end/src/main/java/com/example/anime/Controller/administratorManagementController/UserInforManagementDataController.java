package com.example.anime.Controller.administratorManagementController;

import com.example.anime.Service.administratorManagementService.LogBoardManagementDataService;
import com.example.anime.Service.administratorManagementService.UserInforManagementDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.anime.Entity.userLoginInformationEntity.UserLoginInformationEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("administrator")
public class UserInforManagementDataController {
    @Autowired
    private UserInforManagementDataService userInforManagementDataService;
    @Autowired
    private LogBoardManagementDataService logBoardManagementDataService;

    @RequestMapping("getUserInforData")
    @ResponseBody
    public List<UserLoginInformationEntity> getUserInforData(){
        return userInforManagementDataService.getUserInforData();
    }

    @RequestMapping("getUserInforByUserPermission")
    @ResponseBody
    public List<UserLoginInformationEntity> getUserInforByUserPermission(String userPermission){
        return userInforManagementDataService.getUserInforByUserPermission(userPermission);
    }

    @RequestMapping("getUserInforByUserName")
    @ResponseBody
    public List<UserLoginInformationEntity> getUserInforByUserName(String name){
        return userInforManagementDataService.getUserInforByUserName(name);
    }

    @RequestMapping("getUserInforByPhone")
    @ResponseBody
    public List<UserLoginInformationEntity> getUserInforByPhone(String phone){
        return userInforManagementDataService.getUserInforByPhone(phone);
    }

    @RequestMapping("getUserInforByEmail")
    @ResponseBody
    public List<UserLoginInformationEntity> getUserInforByEmail(String email){
        return userInforManagementDataService.getUserInforByEmail(email);
    }

    @RequestMapping("modifyUserInforData")
    @ResponseBody
    public Integer modifyUserInforData(UserLoginInformationEntity userLoginInformationEntity){
        return userInforManagementDataService.modifyUserInforData(userLoginInformationEntity);
    }

    @RequestMapping("deleteUserInforData")
    @ResponseBody
    public Integer deleteUserInforData(String username, String phone){
        return userInforManagementDataService.deleteUserInforData(username, phone);
    }

    @RequestMapping("addUserInforData")
    @ResponseBody
    public Integer addUserInforData(UserLoginInformationEntity userLoginInformationEntity){
        System.out.println("接收到数据");
        return userInforManagementDataService.addUserInforData(userLoginInformationEntity);
    }
}
