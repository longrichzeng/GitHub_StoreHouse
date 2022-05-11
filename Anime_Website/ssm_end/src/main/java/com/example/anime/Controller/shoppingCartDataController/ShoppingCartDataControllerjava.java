package com.example.anime.Controller.shoppingCartDataController;

import com.example.anime.Dto.transmitJinpinImageDTO;
import com.example.anime.Entity.shoppingCartDataEntity.ShoppingCartDataEntity;
import com.example.anime.Dto.ShoppingCartInformationDTO;
import com.example.anime.Service.administratorManagementService.DataAnalysisManagementDataService;
import com.example.anime.Service.administratorManagementService.LogBoardManagementDataService;
import com.example.anime.temporyPackage.Util.GenerateNumberUtil;
import com.example.anime.temporyPackage.Util.ImageProcessingUtil;
import com.example.anime.temporyPackage.Util.LogPreserveUtil;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.anime.Service.shoppingCartDataService.ShoppingCartDataService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("ShoppingCart")
public class ShoppingCartDataControllerjava {
    @Autowired
    private ShoppingCartDataService shoppingCartDataService;
    @Autowired
    private LogBoardManagementDataService logBoardManagementDataService;
    @Autowired
    private DataAnalysisManagementDataService dataAnalysisManagementDataService;

    /**
     * 本方法的使用流程是，在新加入一组数据前，根据获取到的数据中的购买者以及购买编号，判断数据库中是否存在符合的条件，符合则只做修改操作，否则做添加操作。
     * @param shoppingCartDataEntity
     * @return
     */
    @RequestMapping("addJinpinToShoppingCart")
    @ResponseBody
    public Integer addJinpinToShoppingCart(ShoppingCartDataEntity shoppingCartDataEntity){
        String buyingUser = shoppingCartDataEntity.getJinPinBuyingUser();
        logBoardManagementDataService.addLogBoard(buyingUser,"执行了添加景品到购物车的操作","/ShoppingCart/addJinpinToShoppingCart","暂无备注！");

        GenerateNumberUtil generateNumberUtil = new GenerateNumberUtil();
        dataAnalysisManagementDataService.modifyOneJinpinModelDataTotal(generateNumberUtil.generateTime());
        String jinPinNumber = shoppingCartDataEntity.getShoppingCartJinPinNumber();
        String jinPinBuyingUser = shoppingCartDataEntity.getJinPinBuyingUser();

        List<ShoppingCartDataEntity> shoppingCartData = shoppingCartDataService.getUserShoppingCart(jinPinBuyingUser);
        for(int account = 0; account < shoppingCartData.size(); account++){
            if(shoppingCartData.get(account).getShoppingCartJinPinNumber().equals(jinPinNumber)){
                return shoppingCartDataService.addJinPinPurchaseQuantity(jinPinNumber, jinPinBuyingUser);
            }
        }
        return shoppingCartDataService.addJinpinToShoppingCart(shoppingCartDataEntity);
    }

    @RequestMapping("getUserShoppingCart")
    @ResponseBody
    public List<ShoppingCartDataEntity> getUserShoppingCart(String jinPinBuyingUser){
        logBoardManagementDataService.addLogBoard(jinPinBuyingUser,"执行了从购物车获取景品的操作","/ShoppingCart/getUserShoppingCart","暂无备注！");
        return shoppingCartDataService.getUserShoppingCart(jinPinBuyingUser);
    }

    @RequestMapping("getUserTotalShoppingCartData")
    @ResponseBody
    public List<ShoppingCartInformationDTO> getUserTotalShoppingCartData(String jinPinBuyingUser){
        List<ShoppingCartInformationDTO> TotalShoppingCartData = shoppingCartDataService.getUserTotalShoppingCartData(jinPinBuyingUser);
        ImageProcessingUtil imageProcessingUtil = new ImageProcessingUtil();
        List All = new ArrayList();

        for(int i = 0; i < TotalShoppingCartData.size(); i++){
            ShoppingCartInformationDTO AllInfor = new ShoppingCartInformationDTO();
//            File tempAnime = new File(TotalShoppingCartData.get(i).getJinpinImage());
//            AllInfor.setJinpinImage(imageProcessingUtil.getImageBinary(tempAnime));

            AllInfor.setJinpinImage(TotalShoppingCartData.get(i).getJinpinImage());
            AllInfor.setJinPinNumber(TotalShoppingCartData.get(i).getJinPinNumber());
            AllInfor.setJinPinName(TotalShoppingCartData.get(i).getJinPinName());
            AllInfor.setJinPinType(TotalShoppingCartData.get(i).getJinPinType());
            AllInfor.setJinPinPrice(TotalShoppingCartData.get(i).getJinPinPrice());
            AllInfor.setJinPinManufacturer(TotalShoppingCartData.get(i).getJinPinManufacturer());
            AllInfor.setJinPinBuyingUser(TotalShoppingCartData.get(i).getJinPinBuyingUser());
            AllInfor.setJinPinPurchaseQuantity(TotalShoppingCartData.get(i).getJinPinPurchaseQuantity());
            AllInfor.setJinPinTotalPrice(TotalShoppingCartData.get(i).getJinPinTotalPrice());

            All.add(AllInfor);
        }
        return All;

    }

    @RequestMapping("deleteShoppingCartData")
    @ResponseBody
    public Integer deleteShoppingCartData(String shoppingCartJinPinNumber, String jinPinBuyingUser){
        logBoardManagementDataService.addLogBoard(jinPinBuyingUser,"执行了将景品从购物车删除的操作","/ShoppingCart/deleteShoppingCartData","暂无备注！");
        return shoppingCartDataService.deleteShoppingCartData(shoppingCartJinPinNumber, jinPinBuyingUser);
    }

    @RequestMapping("deleteAllShoppingCartData")
    @ResponseBody
    public Integer deleteAllShoppingCartData(String jinPinBuyingUser){
        logBoardManagementDataService.addLogBoard(jinPinBuyingUser,"执行了将所有景品从购物车删除的操作","/ShoppingCart/deleteAllShoppingCartData","暂无备注！");
        return shoppingCartDataService.deleteAllShoppingCartData(jinPinBuyingUser);
    }

    @RequestMapping("addJinPinPurchaseQuantity")
    @ResponseBody
    public Integer addJinPinPurchaseQuantity(String shoppingCartJinPinNumber, String jinPinBuyingUser){
        GenerateNumberUtil generateNumberUtil = new GenerateNumberUtil();
        dataAnalysisManagementDataService.modifyOneJinpinModelDataTotal(generateNumberUtil.generateTime());
        logBoardManagementDataService.addLogBoard(jinPinBuyingUser,"执行了添加一个景品到购物车的操作","/ShoppingCart/addJinPinPurchaseQuantity", shoppingCartJinPinNumber);
        return shoppingCartDataService.addJinPinPurchaseQuantity(shoppingCartJinPinNumber, jinPinBuyingUser);
    }

    @RequestMapping("subJinPinPurchaseQuantity")
    @ResponseBody
    public Integer subJinPinPurchaseQuantity(String shoppingCartJinPinNumber, String jinPinBuyingUser){
        logBoardManagementDataService.addLogBoard(jinPinBuyingUser,"执行了减少一个景品到购物车的操作","/ShoppingCart/subJinPinPurchaseQuantity", shoppingCartJinPinNumber);
        return shoppingCartDataService.subJinPinPurchaseQuantity(shoppingCartJinPinNumber, jinPinBuyingUser);
    }
}
