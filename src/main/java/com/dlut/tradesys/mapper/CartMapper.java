package com.dlut.tradesys.mapper;

import com.dlut.tradesys.common.pojo.Cart;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CartMapper {
    @Select("select * from cart where user_id = #{userId}")
    List<Cart> getCart(Long userId);

    @Insert("insert into cart (user_id, item_id, amount, spec_id, shop_id) values " +
            "(#{userId}, #{itemId}, #{amount}, #{specId}, #{shopId})")
    boolean addCart(Cart cart);

    @Update("update cart set amount = #{amount} where id = #{cartId}")
    boolean modifyCartAmount(Long cartId, Integer amount);

    @Delete("delete from cart where id = #{cartId}")
    boolean deleteCart(Long cartId);

    // 外部service使用
    @Select("select * from cart where id = #{cartId}")
    Cart getCartById(Long cartId);
}
