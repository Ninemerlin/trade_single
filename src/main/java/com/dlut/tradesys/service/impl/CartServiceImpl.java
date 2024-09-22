package com.dlut.tradesys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.dlut.tradesys.common.pojo.Cart;
import com.dlut.tradesys.common.pojo.Item;
import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.common.vo.CartGroupVO;
import com.dlut.tradesys.common.vo.CartVO;
import com.dlut.tradesys.mapper.CartMapper;
import com.dlut.tradesys.mapper.ItemMapper;
import com.dlut.tradesys.mapper.ShopMapper;
import com.dlut.tradesys.mapper.SpecMapper;
import com.dlut.tradesys.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartMapper cartMapper;
    private final ShopMapper shopMapper;
    private final ItemMapper itemMapper;
    private final SpecMapper specMapper;

    @Override
    public Result getCart(Long userId) {
        List<Cart> c = cartMapper.getCart(userId);
        List<CartVO> cartVOList = new ArrayList<>();
        Set<Long> shopIds = new HashSet<>();
        for (Cart cart : c) shopIds.add(cart.getShopId());
        for (Long shopId : shopIds) {
            CartVO cartVO = new CartVO();
            List<CartGroupVO> cartGroupVOList = new ArrayList<>();
            for (Cart cart : c){
                if (cart.getShopId().equals(shopId)){
                    Item item = itemMapper.getItemById(cart.getItemId());
                    CartGroupVO cartGroupVO = BeanUtil.copyProperties(item, CartGroupVO.class);
                    cartGroupVO.setCartId(cart.getId());
                    cartGroupVO.setItemId(cart.getItemId());
                    cartGroupVO.setSpecId(cart.getSpecId());
                    cartGroupVO.setSpec(specMapper.getSpecById(cart.getSpecId()));
                    cartGroupVO.setAmount(cart.getAmount());
                    cartGroupVOList.add(cartGroupVO);
                }
            }
            cartVO.setShopId(shopId);
            cartVO.setShopName(shopMapper.getShopNameById(shopId));
            cartVO.setItems(cartGroupVOList);
            cartVOList.add(cartVO);
        }
        return Result.success().addMsg("购物车查询成功.").addData("cartList", cartVOList);
    }

    @Override
    public Result addCart(Long userId, Cart cart) {
        List<CartVO> cartVOList = (List<CartVO>) getCart(userId).getData().get("cartList");

        for (CartVO cartVO : cartVOList){
            if (cartVO.getShopId().equals(cart.getShopId())){
                List<CartGroupVO> items = cartVO.getItems();
                for (CartGroupVO cartGroupVO : items){
                    if(cartGroupVO.getItemId().equals(cart.getItemId()) && cartGroupVO.getSpecId().equals(cart.getSpecId())){
                        if(cartMapper.modifyCartAmount(cartGroupVO.getCartId(),cartGroupVO.getAmount() + cart.getAmount())){
                            return Result.success().addMsg("购物车已存在该物品, 数量增加成功。");
                        }
                    }
                }
            }
        }
        cart.setUserId(userId);
        if(cartMapper.addCart(cart)) {
            return Result.success().addMsg("购物车添加成功.");
        }
        return Result.fail().addMsg("购物车添加失败.");
    }
}
