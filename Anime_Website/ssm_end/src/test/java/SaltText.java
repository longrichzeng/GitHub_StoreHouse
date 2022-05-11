import com.example.anime.temporyPackage.Util.SaltGenerateUtil;

public class SaltText {
    public static void main(String[] args){
        SaltText saltText = new SaltText();
        for (int i = 0; i < 10; i++)
            saltText.textSaltGenerate();
    }

    public void textSaltGenerate(){
        String tempText = SaltGenerateUtil.GenerateSalt(8);
        System.out.println(tempText);
    }
}
