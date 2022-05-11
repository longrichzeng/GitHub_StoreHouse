package com.example.anime.Controller.userLoginInformationController;

import com.example.anime.Dto.UserLoginInformationDTO;
import com.example.anime.Entity.administratorManagementEntity.LogBoardManagementDataEntity;
import com.example.anime.Entity.userLoginInformationEntity.UserLoginInformationEntity;
import com.example.anime.Service.administratorManagementService.DataAnalysisManagementDataService;
import com.example.anime.Service.administratorManagementService.LogBoardManagementDataService;
import com.example.anime.temporyPackage.Result.FactoryResult;
import com.example.anime.temporyPackage.Result.ResultDTO;
import com.example.anime.temporyPackage.Util.GenerateNumberUtil;
import com.example.anime.temporyPackage.Util.LogPreserveUtil;
import com.example.anime.temporyPackage.Util.TokenGenerateUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.anime.Service.userLoginInformationService.UserLoginInformationService;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("login")
public class UserLoginInformationController {
    @Autowired
    private UserLoginInformationService userLoginInformationService;
    @Autowired
    private LogBoardManagementDataService logBoardManagementDataService;
    @Autowired
    private DataAnalysisManagementDataService dataAnalysisManagementDataService;

    @RequestMapping("loginInfor")
    @ResponseBody
    public ResultDTO loginInfor(String username, String password, HttpSession session, HttpServletRequest request){
        logBoardManagementDataService.addLogBoard(username,"执行了登陆操作","/login/loginInfor","暂无备注");
        System.out.println(username + "\t" +password);
        FactoryResult factoryResult = new FactoryResult();
        Subject subject = SecurityUtils.getSubject();
        username = HtmlUtils.htmlEscape(username);
        password = HtmlUtils.htmlEscape(password);
        try{
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            System.out.println("完成！");
            subject.login(token);
            GenerateNumberUtil generateNumberUtil = new GenerateNumberUtil();
            dataAnalysisManagementDataService.modifyOneAnimeDrameDataTotal(generateNumberUtil.generateTime());
            UserLoginInformationEntity userInfor = userLoginInformationService.getUserInfor(username);
            String userPermission = userInfor.getUserPermission();
            return factoryResult.successResult(TokenGenerateUtil.TokenGenerate(username), username, userPermission);
        } catch (UnknownAccountException e){
            e.printStackTrace();
            System.out.println("用户名错误！");
            logBoardManagementDataService.addLogBoard(username,"执行了登陆操作","/login/loginInfor","用户名错误");
        } catch (IncorrectCredentialsException e){
            e.printStackTrace();
            logBoardManagementDataService.addLogBoard(username,"执行了登陆操作","/login/loginInfor","密码错误");
            System.out.println("密码错误！");
        } catch (Exception e){
            e.printStackTrace();
            logBoardManagementDataService.addLogBoard(username,"执行了登陆操作","/login/loginInfor","其他错误");
            System.out.println("其他错误！");
        }
        return factoryResult.failResult();
    }

    @RequestMapping("logout")
    @ResponseBody
    public void logout(String username){
        logBoardManagementDataService.addLogBoard(username,"执行了登出操作","/login/loginInfor","缓存数据以及删除！");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

    @RequestMapping("getUserInfor")
    @ResponseBody
    public UserLoginInformationEntity getUserInfor(String username){
        logBoardManagementDataService.addLogBoard(username,"执行了获取用户信息操作","/login/getUserInfor","暂无备注！");
        return userLoginInformationService.getUserInfor(username);
    }

    @RequestMapping("addRegisteredInfor")
    @ResponseBody
    public Integer addRegisteredInfor(UserLoginInformationEntity userLoginInformationEntity){
        GenerateNumberUtil generateNumberUtil = new GenerateNumberUtil();
        dataAnalysisManagementDataService.modifyOneAnimeMusicDataTotal(generateNumberUtil.generateTime());
        logBoardManagementDataService.addLogBoard("游客用户","执行了注册操作","/login/addRegisteredInfor","暂无备注！");
        return userLoginInformationService.addRegisteredInfor(userLoginInformationEntity);
    }

    @RequestMapping("deleteAllUserLoginInforData")
    @ResponseBody
    public Integer deleteAllUserLoginInforData(String userName){
        logBoardManagementDataService.addLogBoard("管理员","执行了删除所有登录信息数据操作","/login/deleteAllUserLoginInforData","暂无备注！");
        return userLoginInformationService.deleteAllUserLoginInforData(userName);
    }
}
