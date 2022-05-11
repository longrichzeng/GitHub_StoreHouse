package com.example.anime.Controller.upLoadImageController;

import com.example.anime.Dto.transmitAnimeDrameImageDTO;
import com.example.anime.Dto.transmitJinpinImageDTO;
import com.example.anime.temporyPackage.Util.GenerateNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.anime.Entity.administratorManagementEntity.JinpinModelManagementDataEntity;
import com.example.anime.Service.administratorManagementService.JinpinModelManagementDataService;
import com.example.anime.temporyPackage.Util.ImageProcessingUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("upload")
public class UpLoadJinpinModuelImageController {
    @Autowired
    private JinpinModelManagementDataService jinpinModelManagementDataService;

    /**
     * 通过获取到服务器的数据库表中的AnimeDrame图片的路径，然后
     */
    @RequestMapping("transmitJinpinImageToWeb")
    @ResponseBody
    public List<transmitAnimeDrameImageDTO> transmitImageToWeb(){
        List<JinpinModelManagementDataEntity> jinpinData = jinpinModelManagementDataService.getJinpinModelData();
        ImageProcessingUtil imageProcessingUtil = new ImageProcessingUtil();
        List All = new ArrayList();
        System.out.print("进度条：/");
        for(int i = 0; i < jinpinData.size(); i++){
            transmitJinpinImageDTO AllInfor = new transmitJinpinImageDTO();
//            File tempAnime = new File(jinpinData.get(i).getJinpinImage());
//            AllInfor.setJinPinImage(imageProcessingUtil.getImageBinary(tempAnime));
            AllInfor.setJinPinNumber(jinpinData.get(i).getJinPinNumber());
            AllInfor.setJinPinName(jinpinData.get(i).getJinPinName());
            AllInfor.setJinPinType(jinpinData.get(i).getJinPinType());
            AllInfor.setJinPinPrice(jinpinData.get(i).getJinPinPrice());

            System.out.print("*");
            All.add(AllInfor);
        }
        System.out.print("/");
        System.out.print("\n完成！");
        return All;
    }
}
