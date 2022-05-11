import com.example.anime.temporyPackage.Result.CodeResult;
import com.example.anime.temporyPackage.Result.FactoryResult;
import com.example.anime.temporyPackage.Result.ResultDTO;

public class ResultMessageText {
    public static void main(String[] args){
        System.out.println(CodeResult.SUCCESS.code);
        System.out.println(CodeResult.FAIL.code);
        System.out.println(CodeResult.INTERNAL_SERVER_ERROR.code);
        System.out.println(CodeResult.NOT_FOUND.code);
        System.out.println(CodeResult.UNAUTHORIZED.code);
        System.out.println("/************************************************************/");

        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(302);
        resultDTO.setMessage("登录成功！");
        resultDTO.setToken("ajiodsfhvcnasodivfhgsad");
        System.out.println(resultDTO.code);
        System.out.println(resultDTO.message);
        System.out.println(resultDTO.token);
        System.out.println("/************************************************************/");

        FactoryResult factoryResult = new FactoryResult();
//        System.out.println(factoryResult.successResult("sldgivhsxolfdknmgvb").getCode());
//        System.out.println(factoryResult.successResult("sldgivhsxolfdknmgvb").getMessage());
//        System.out.println(factoryResult.successResult("sldgivhsxolfdknmgvb").getToken());
    }
}
