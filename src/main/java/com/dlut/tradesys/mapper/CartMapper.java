package com.dlut.tradesys.mapper;

import com.dlut.tradesys.common.pojo.Cart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartMapper {
    @Select("select * from cart where user_id = #{userId}")
    List<Cart> getCart(Long userId);

    @Insert("insert into cart (user_id, item_id, amount, spec_id, shop_id) values " +
            "(#{userId}, #{itemId}, #{amount}, #{specId}, #{shopId})")
    boolean addCart(Cart cart);
}
