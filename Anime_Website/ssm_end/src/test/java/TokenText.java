import com.example.anime.temporyPackage.Util.TokenGenerateUtil;

import java.util.Base64;

public class TokenText {
    public static void main(String[] argc){
        String tempToken = TokenGenerateUtil.TokenGenerate("LongRich");
        System.out.println(tempToken);
        for (int i = 0; i < 5; i++){
            tempToken = new String(Base64.getDecoder().decode(tempToken.getBytes()));
        }
        System.out.println(tempToken);
    }
}
