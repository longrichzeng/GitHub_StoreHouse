package com.example.anime.Service.shoppingCartDataService.shoppingCartDataServiceImpl;

import com.example.anime.Dto.ShoppingCartInformationDTO;
import com.example.anime.Entity.administratorManagementEntity.JinpinModelManagementDataEntity;
import com.example.anime.Entity.shoppingCartDataEntity.ShoppingCartDataEntity;
import com.example.anime.Service.shoppingCartDataService.ShoppingCartDataService;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.anime.Dao.shoppingCartDataDao.ShoppingCartDataDao;

import java.util.List;

@Service
public class ShoppingCartDataServiceImpl implements ShoppingCartDataService {
    @Autowired
    private ShoppingCartDataDao shoppingCartDataDao;

    @Override
    public Integer addJinpinToShoppingCart(ShoppingCartDataEntity shoppingCartDataEntity){
        String jinPinNumber = shoppingCartDataEntity.getShoppingCartJinPinNumber();
        String jinPinBuyingUser = shoppingCartDataEntity.getJinPinBuyingUser();
        String jinPinPrice = shoppingCartDataEntity.getJinPinPrice();
        String jinPinPurchaseQuantity = shoppingCartDataEntity.getJinPinPurchaseQuantity();
        String jinPinTotalPrice = shoppingCartDataEntity.getJinPinTotalPrice();
        if(jinPinNumber != null && jinPinBuyingUser != null && jinPinPrice != null &&
                jinPinPurchaseQuantity != null && jinPinTotalPrice != null){
            return shoppingCartDataDao.addJinpinToShoppingCart(shoppingCartDataEntity);
        }else{
            return shoppingCartDataDao.addJinpinToShoppingCart(null);
        }
    }

    @Override
    public List<ShoppingCartDataEntity> getUserShoppingCart(String jinPinBuyingUser){
        return shoppingCartDataDao.getUserShoppingCart(jinPinBuyingUser);
    }

    @Override
    public List<ShoppingCartInformationDTO> getUserTotalShoppingCartData(String jinPinBuyingUser){
        return shoppingCartDataDao.getUserTotalShoppingCartData(jinPinBuyingUser);
    }

    @Override
    public Integer deleteShoppingCartData(String shoppingCartJinPinNumber, String jinPinBuyingUser){
        return shoppingCartDataDao.deleteShoppingCartData(shoppingCartJinPinNumber, jinPinBuyingUser);
    }

    @Override
    public Integer deleteAllShoppingCartData(String jinPinBuyingUser){
        return shoppingCartDataDao.deleteAllShoppingCartData(jinPinBuyingUser);
    }

    @Override
    public Integer addJinPinPurchaseQuantity(String shoppingCartJinPinNumber, String jinPinBuyingUser){
        return shoppingCartDataDao.addJinPinPurchaseQuantity(shoppingCartJinPinNumber, jinPinBuyingUser);
    }

    @Override
    public Integer subJinPinPurchaseQuantity(String shoppingCartJinPinNumber, String jinPinBuyingUser){

        return shoppingCartDataDao.subJinPinPurchaseQuantity(shoppingCartJinPinNumber, jinPinBuyingUser);
    }
}
