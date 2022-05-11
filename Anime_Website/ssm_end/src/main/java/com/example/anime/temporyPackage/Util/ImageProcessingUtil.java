package com.example.anime.temporyPackage.Util;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class ImageProcessingUtil {
    static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
    static BASE64Decoder decoder = new sun.misc.BASE64Decoder();

    /**
     * 该方法的功能通过获取图片的路径，找到图片，然后转换成base64码并返回
     * @param file
     * @return
     */
    public String getImageBinary(File file) {
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

    /**
     * 该方法的功能是通过获取base64码，然后转换成png图片并存储起来
     * @param base64String
     */
    public void base64StringToImage(String base64String) {
        GenerateNumberUtil generateNumberUtil = new GenerateNumberUtil();
        try {
            byte[] bytes1 = decoder.decodeBuffer(base64String);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            BufferedImage bi1 = ImageIO.read(bais);

            // 可以是jpg,png,gif格式
            File w2 = new File("E://TextImageFile//" + generateNumberUtil.generateAnimeDrameNumber() + ".png");

            // 不管输出什么格式图片，此处不需改动
            ImageIO.write(bi1, "png", w2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
