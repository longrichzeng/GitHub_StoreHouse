import com.example.anime.AnimeApplication;
import com.example.anime.Entity.administratorManagementEntity.LogBoardManagementDataEntity;
import com.example.anime.Service.administratorManagementService.LogBoardManagementDataService;
import com.example.anime.Service.administratorManagementService.administratorManagementServiceImpl.LogBoardManagementDataServiceImpl;
import com.example.anime.temporyPackage.Util.GenerateNumberUtil;
import com.example.anime.temporyPackage.Util.LogPreserveUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AnimeApplication.class)
public class OthersText {
    @Autowired
    private LogBoardManagementDataService logBoardManagementDataService;

    @Test
    public void test() {
//        LogBoardManagementDataServiceImpl logBoardManagementDataService = new LogBoardManagementDataServiceImpl();
//        GenerateNumberUtil generateNumberUtil = new GenerateNumberUtil();
//        LogBoardManagementDataEntity logBoardManagementDataEntity = new LogBoardManagementDataEntity();
//
//
//        logBoardManagementDataEntity.setLogNumber(generateNumberUtil.generateLogNumber());
//        logBoardManagementDataEntity.setExecutor("hanabi");
//        logBoardManagementDataEntity.setExecuteEvent("执行了登陆操作");
//        logBoardManagementDataEntity.setAccessInterface("/Login/LoginInfor");
//        logBoardManagementDataEntity.setRemark("暂无备注");
//        logBoardManagementDataEntity.setExecutionTime(generateNumberUtil.generateDate());
//        logBoardManagementDataService.addLogBoard(logBoardManagementDataEntity);
        GenerateNumberUtil generateNumberUtil = new GenerateNumberUtil();
        System.out.println(generateNumberUtil.generateTime());
    }


//    public static void main(String[] args){

//        UserLoginInformationServiceImpl userLoginInformationServiceImpl = null;
//        UserLoginInformationEntity userLoginInformationEntity = new UserLoginInformationEntity();
//        userLoginInformationEntity.setUsername("LongRich");
//        userLoginInformationEntity.setPassword("123456");
//        userLoginInformationEntity.setSalt("null");
//        userLoginInformationEntity.setName("曾長富");
//        userLoginInformationEntity.setEmail("2864659907@qq.com");
//        userLoginInformationEntity.setPhone("13169485319");
//        userLoginInformationEntity.setUserPermission("null");
//
//        userLoginInformationServiceImpl.addRegisteredInfor(userLoginInformationEntity);
//        GenerateNumberUtil generateNumberUtil = new GenerateNumberUtil();

//    }
}
