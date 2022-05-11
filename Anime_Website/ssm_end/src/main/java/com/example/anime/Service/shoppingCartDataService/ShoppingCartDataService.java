package com.example.anime.Service.shoppingCartDataService;

import com.example.anime.Dto.ShoppingCartInformationDTO;
import com.example.anime.Entity.administratorManagementEntity.JinpinModelManagementDataEntity;
import com.example.anime.Entity.shoppingCartDataEntity.ShoppingCartDataEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface ShoppingCartDataService {
    Integer addJinpinToShoppingCart(ShoppingCartDataEntity shoppingCartDataEntity);

    List<ShoppingCartDataEntity> getUserShoppingCart(String jinPinBuyingUser);

    List<ShoppingCartInformationDTO> getUserTotalShoppingCartData(String jinPinBuyingUser);

    Integer deleteShoppingCartData(String shoppingCartJinPinNumber, String jinPinBuyingUser);

    Integer deleteAllShoppingCartData(String jinPinBuyingUser);

    Integer addJinPinPurchaseQuantity(String shoppingCartJinPinNumber, String jinPinBuyingUser);

    Integer subJinPinPurchaseQuantity(String shoppingCartJinPinNumber, String jinPinBuyingUser);
}
