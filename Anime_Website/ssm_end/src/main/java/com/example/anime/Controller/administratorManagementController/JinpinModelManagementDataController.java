package com.example.anime.Controller.administratorManagementController;

import com.example.anime.Dao.administratorManagementDao.JinpinModelManagementDataDao;
import com.example.anime.Entity.administratorManagementEntity.AnimeDrameManagementDataEntity;
import com.example.anime.Service.administratorManagementService.JinpinModelManagementDataService;
import com.example.anime.Service.administratorManagementService.LogBoardManagementDataService;
import com.example.anime.temporyPackage.Util.GenerateNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.anime.Entity.administratorManagementEntity.JinpinModelManagementDataEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Controller
@RequestMapping("administrator")
public class JinpinModelManagementDataController {
    @Autowired
    private JinpinModelManagementDataService jinpinModelManagementDataService;
    @Autowired
    private LogBoardManagementDataService logBoardManagementDataService;

    @RequestMapping("getJinpinModelData")
    @ResponseBody
    public List<JinpinModelManagementDataEntity> getJinpinModelData(){
        return jinpinModelManagementDataService.getJinpinModelData();
    }

    @RequestMapping("getJinpinDataByIndex")
    @ResponseBody
    public List<JinpinModelManagementDataEntity> getJinpinDataByIndex(String jinPinRecommendIndex){
        return jinpinModelManagementDataService.getJinpinDataByIndex(jinPinRecommendIndex);
    }

    @RequestMapping("getJinpinDataByName")
    @ResponseBody
    public List<JinpinModelManagementDataEntity> getJinpinDataByName(String jinPinName){
        return jinpinModelManagementDataService.getJinpinDataByName(jinPinName);
    }

    @RequestMapping("modifyJinpinModelData")
    @ResponseBody
    public Integer modifyJinpinModelData(@RequestParam("file") MultipartFile file, JinpinModelManagementDataEntity jinpinModelManagementDataEntity) throws Exception {
        //获取需要修改信息的animeNumber
        String jinPinNumber = jinpinModelManagementDataEntity.getJinPinNumber();
        //生成需要操作的anime图片绝对路径
        String imagePath = "F:\\Anime_Website\\vue_front\\src\\assets\\jinpinImage\\" + jinPinNumber + ".png";
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
            return jinpinModelManagementDataService.modifyJinpinModelData(jinpinModelManagementDataEntity);
        } else {
            return jinpinModelManagementDataService.modifyJinpinModelData(jinpinModelManagementDataEntity);
        }
    }

    @RequestMapping("deleteJinpinModelData")
    @ResponseBody
    public Integer deleteJinpinModelData(String jinPinNumber){
        return jinpinModelManagementDataService.deleteJinpinModelData(jinPinNumber);
    }

    @RequestMapping("addJinpinModelData")
    @ResponseBody
    public Integer addJinpinModelData(@RequestParam("file") MultipartFile file, JinpinModelManagementDataEntity jinpinModelManagementDataEntity) throws Exception{
        GenerateNumberUtil generateNumberUtil = new GenerateNumberUtil();

        String jinpinNumber = generateNumberUtil.generateJinpinNumber();
        String jinpinImageUrl = "F:\\Anime_Website\\vue_front\\src\\assets\\jinpinImage\\" + jinpinNumber + ".png";

        if (file != null){
            System.out.println("接收成功");
            File destFile = new File(jinpinImageUrl);
            file.transferTo(destFile);

            jinpinModelManagementDataEntity.setJinPinNumber(jinpinNumber);
            return jinpinModelManagementDataService.addJinpinModelData(jinpinModelManagementDataEntity);
        }else{
            System.out.println("接收失败");
        }
        return jinpinModelManagementDataService.addJinpinModelData(null);
    }

}
