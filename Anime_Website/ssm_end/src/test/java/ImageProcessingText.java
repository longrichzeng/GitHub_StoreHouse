import com.example.anime.Dao.administratorManagementDao.AnimeDrameManagementDataDao;
import com.example.anime.Entity.administratorManagementEntity.AnimeDrameManagementDataEntity;
import com.example.anime.Service.administratorManagementService.AnimeDrameManagementDataService;
import com.example.anime.Service.administratorManagementService.administratorManagementServiceImpl.AnimeDrameManagementDataServiceImpl;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class ImageProcessingText {
    static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
    static BASE64Decoder decoder = new sun.misc.BASE64Decoder();

    public static void main(String[] args){
        File file = new File("F:/Anime_Website/animeImage");
        File result[] = file.listFiles();
        System.out.print("进度条：/");
        for (int i = 0; i < result.length; i++) {
            base64StringToImage(getImageBinary(result[i]));
            System.out.print("*");
        }
        System.out.print("/");
        System.out.print("\n完成！");
    }

    public static String getImageBinary(File file) {
        BufferedImage bi;
        try {
            bi = ImageIO.read(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "png", baos);  //经测试转换的图片是格式这里就什么格式，否则会失真
            byte[] bytes = baos.toByteArray();
            return encoder.encodeBuffer(bytes).trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void base64StringToImage(String base64String) {
        try {
            byte[] bytes1 = decoder.decodeBuffer(base64String);

            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            BufferedImage bi1 = ImageIO.read(bais);

            File w2 = new File("E://TextImageFile//" + generateDateString() + ".png");// 可以是jpg,png,gif格式
//            File w2 = new File("E://1.png");// 可以是jpg,png,gif格式

            ImageIO.write(bi1, "png", w2);// 不管输出什么格式图片，此处不需改动
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generateDateString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMss");
        Date date = new Date();
        String hehe = dateFormat.format(date);
        int randomString = new Random().nextInt(999);
        if(randomString < 10)
            return hehe + "A00" + String.valueOf(randomString);
        else if(randomString < 100)
            return hehe + "A0" + String.valueOf(randomString);
        else
            return hehe + "A" + String.valueOf(randomString);
    }
}
