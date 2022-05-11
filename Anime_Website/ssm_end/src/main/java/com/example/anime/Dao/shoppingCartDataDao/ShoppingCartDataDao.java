package com.example.anime.Dao.shoppingCartDataDao;

import com.example.anime.Dto.ShoppingCartInformationDTO;
import com.example.anime.Entity.shoppingCartDataEntity.ShoppingCartDataEntity;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface ShoppingCartDataDao {
    /**
     * 添加景品编号，景品购买用户，景品单价，景品总价，景品购买数量这五个数据到购物车数据表
     * @param shoppingCartDataEntity
     * @return
     */
    Integer addJinpinToShoppingCart(ShoppingCartDataEntity shoppingCartDataEntity);

    /**
     * 根据景品购买用户再将两张数据表结合起来
     * @param jinPinBuyingUser
     * @return
     */
    List<ShoppingCartDataEntity> getUserShoppingCart(@Param("jinPinBuyingUser")String jinPinBuyingUser);

    /**
     * 根据用户名获取用户完整的购物车信息
     * @param jinPinBuyingUser
     * @return
     */
    List<ShoppingCartInformationDTO> getUserTotalShoppingCartData(@Param("jinPinBuyingUser")String jinPinBuyingUser);

    /**
     * 根据景品的购买者和精品编号来删除符合的数据
     * @param shoppingCartJinPinNumber
     * @param jinPinBuyingUser
     * @return
     */
    Integer deleteShoppingCartData(@Param("shoppingCartJinPinNumber")String shoppingCartJinPinNumber, @Param("jinPinBuyingUser")String jinPinBuyingUser);

    /**
     * 根据用户名删除该用户所有相关信息
     * @param jinPinBuyingUser
     * @return
     */
    Integer deleteAllShoppingCartData(@Param("jinPinBuyingUser")String jinPinBuyingUser);

    /**
     * 根据景品的购买者和精品编号来增加精品的数量
     * @param shoppingCartJinPinNumber
     * @param jinPinBuyingUser
     * @return
     */
    Integer addJinPinPurchaseQuantity(@Param("shoppingCartJinPinNumber")String shoppingCartJinPinNumber, @Param("jinPinBuyingUser")String jinPinBuyingUser);

    /**
     * 根据景品的购买者和精品编号来减少精品的数量
     * @param shoppingCartJinPinNumber
     * @param jinPinBuyingUser
     * @return
     */
    Integer subJinPinPurchaseQuantity(@Param("shoppingCartJinPinNumber")String shoppingCartJinPinNumber,
                                      @Param("jinPinBuyingUser")String jinPinBuyingUser);
}
