package com.example.anime.Controller.administratorManagementController;

import com.example.anime.Entity.administratorManagementEntity.AnimeDrameManagementDataEntity;
import com.example.anime.Service.administratorManagementService.AnimeDrameManagementDataService;
import com.example.anime.Service.administratorManagementService.LogBoardManagementDataService;
import com.example.anime.temporyPackage.Util.GenerateNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Controller
@RequestMapping("administrator")
public class AnimeDrameManagementDataController {
    @Autowired
    private AnimeDrameManagementDataService animeDrameManagementDataService;
    @Autowired
    private LogBoardManagementDataService logBoardManagementDataService;

    @RequestMapping("getAnimeDrameData")
    @ResponseBody
    public List<AnimeDrameManagementDataEntity> getAnimeDrameData(){
        return animeDrameManagementDataService.getAnimeDrameData();
    }

    @RequestMapping("getAnimeAboutType")
    @ResponseBody
    public List<AnimeDrameManagementDataEntity> getAnimeAboutType(String animeType){
        return animeDrameManagementDataService.getAnimeAboutType(animeType);
    }

    @RequestMapping("getAnimeAboutIndex")
    @ResponseBody
    public List<AnimeDrameManagementDataEntity> getAnimeAboutIndex(String animeRecommendIndex){
        return animeDrameManagementDataService.getAnimeAboutIndex(animeRecommendIndex);
    }

    @RequestMapping("getAnimeAboutName")
    @ResponseBody
    public List<AnimeDrameManagementDataEntity> getAnimeAboutName(String animeName){
        return animeDrameManagementDataService.getAnimeAboutName(animeName);
    }

    @RequestMapping("modifyAnimeDrameData")
    @ResponseBody
    public Integer modifyAnimeDrameData(@RequestParam("file") MultipartFile file, AnimeDrameManagementDataEntity animeDrameManagementDataEntity) throws Exception {
        //获取需要修改信息的animeNumber
        String animeNumber = animeDrameManagementDataEntity.getAnimeNumber();
        //生成需要操作的anime图片绝对路径
        String imagePath = "F:\\Anime_Website\\vue_front\\src\\assets\\animeImage\\" + animeNumber + ".png";
        //实例化一个File对象,名称表示当前存在的文件
        File existeFile = new File(imagePath);
        //先判断接收到的文件是否为空，空则直接保存除图片之外的数据
        if (file != null) {
            //判断需要更改的(animeNumber对应的)图片是否存在,存在的话则删除,再添加新的图片上去,不存在则显示图片删除失败,
            //并且直接把新图片存到相关文件夹中
            if (!existeFile.exists()) {
                System.out.println("删除文件失败：" + imagePath + "不存在！");
                File destFile = new File(imagePath);
                file.transferTo(destFile);
            } else {
                existeFile.delete();
                System.out.println("前端来的图片接收成功");
                File destFile = new File(imagePath);
                file.transferTo(destFile);
            }
            return animeDrameManagementDataService.modifyAnimeDrameData(animeDrameManagementDataEntity);
        } else {
            return animeDrameManagementDataService.modifyAnimeDrameData(animeDrameManagementDataEntity);
        }
    }

    @RequestMapping("deleteAnimeDrameData")
    @ResponseBody
    public Integer deleteAnimeDrameData(String animeNumber){
        return animeDrameManagementDataService.deleteAnimeDrameData(animeNumber);
    }

    @RequestMapping("addAnimeDrameData")
    @ResponseBody
    public Integer addAnimeDrameData(@RequestParam("file") MultipartFile file, AnimeDrameManagementDataEntity animeDrameManagementDataEntity) throws Exception{
        GenerateNumberUtil generateNumberUtil = new GenerateNumberUtil();

        String animeNumber = generateNumberUtil.generateAnimeDrameNumber();
        String animeImageUrl = "F:\\Anime_Website\\vue_front\\src\\assets\\animeImage\\" + animeNumber + ".png";

        if (file != null){
            System.out.println("接收成功");
            File destFile = new File(animeImageUrl);
            file.transferTo(destFile);

            animeDrameManagementDataEntity.setAnimeNumber(animeNumber);
            return animeDrameManagementDataService.addAnimeDrameData(animeDrameManagementDataEntity);
        }else{
            System.out.println("接收失败");
        }
        return animeDrameManagementDataService.addAnimeDrameData(null);
    }
}
