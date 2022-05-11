import com.example.anime.Entity.userLoginInformationEntity.UserLoginInformationEntity;
import com.example.anime.Service.userLoginInformationService.UserLoginInformationService;
import com.example.anime.Service.userLoginInformationService.userLoginInformationServiceImpl.UserLoginInformationServiceImpl;
import com.example.anime.temporyPackage.Constants.ShiroConstant;
import com.example.anime.temporyPackage.Util.SaltGenerateUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;

public class GenerateAdministration {
    public static void main(String[] argc){
        String salt = SaltGenerateUtil.GenerateSalt(ShiroConstant.SALT_LENGTH);
        String tempPassword = "111111";
        Md5Hash password = new Md5Hash(tempPassword, salt, ShiroConstant.HASH_ITERATORS);

        System.out.println(salt);
        System.out.println(password);

//        userLoginInformationEntity.setUsername("getZero");
//        userLoginInformationEntity.setPassword("000000");
//        userLoginInformationEntity.setName("归零者");
//        userLoginInformationEntity.setPhone("13169485319");
//        userLoginInformationEntity.setEmail("2864659907@qq.com");
//        userLoginInformationEntity.setSalt(salt);
//        userLoginInformationEntity.setPassword(password.toHex());
//        userLoginInformationEntity.setUserPermission("Zeroer");

    }
}
