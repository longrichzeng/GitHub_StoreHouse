package com.example.anime.Controller.upLoadImageController;

import com.example.anime.Dao.administratorManagementDao.AnimeDrameManagementDataDao;
import com.example.anime.Dto.transmitAnimeDrameImageDTO;
import com.example.anime.temporyPackage.Util.GenerateNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.example.anime.Entity.administratorManagementEntity.AnimeDrameManagementDataEntity;
import com.example.anime.Service.administratorManagementService.AnimeDrameManagementDataService;
import com.example.anime.temporyPackage.Util.ImageProcessingUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("upload")
public class UpLoadAnimeDrameImageController {
    @Autowired
    private AnimeDrameManagementDataService animeDrameManagementDataService;

    /**
     * 通过获取到服务器的数据库表中的AnimeDrame图片的路径，然后
     */
    @RequestMapping("transmitAnimeImageToWeb")
    @ResponseBody
    public List<transmitAnimeDrameImageDTO> transmitImageToWeb(){
        List<AnimeDrameManagementDataEntity> animeDrame = animeDrameManagementDataService.getAnimeDrameData();
        ImageProcessingUtil imageProcessingUtil = new ImageProcessingUtil();
        List All = new ArrayList();
        System.out.print("进度条：/");
        for(int i = 0; i < animeDrame.size(); i++){
            transmitAnimeDrameImageDTO AllInfor = new transmitAnimeDrameImageDTO();
//            File tempAnime = new File(animeDrame.get(i).getAnimeImage());
//            AllInfor.setAnimeImage(imageProcessingUtil.getImageBinary(tempAnime));
            AllInfor.setAnimeNumber(animeDrame.get(i).getAnimeNumber());
            System.out.print("*");
            All.add(i, AllInfor);
        }
        System.out.print("/");
        System.out.print("\n完成！");
        return All;
    }

//    @RequestMapping(value = "getImageFromWeb", method = RequestMethod.POST)
//    @ResponseBody
//    public Integer getImageFromWeb(@RequestParam("file") MultipartFile file, AnimeDrameManagementDataEntity animeDrameManagementDataEntity) throws Exception{
//        GenerateNumberUtil generateNumberUtil = new GenerateNumberUtil();
//
//        String animeNumber = generateNumberUtil.generateAnimeDrameNumber();
//        String animeImageUrl = "E:\\" + animeNumber + ".png";
//
//        if (file != null){
//            System.out.println("接收成功");
//            File destFile = new File(animeImageUrl);
//            file.transferTo(destFile);
//
//            animeDrameManagementDataEntity.setAnimeNumber(animeNumber);
//            animeDrameManagementDataEntity.setAnimeImage(animeImageUrl);
//            return animeDrameManagementDataService.addAnimeDrameData(animeDrameManagementDataEntity);
//        }else{
//            System.out.println("接收失败");
//        }
//        return animeDrameManagementDataService.addAnimeDrameData(null);
//    }
}
