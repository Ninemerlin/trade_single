package com.dlut.tradesys.mapper;

import com.dlut.tradesys.common.pojo.Shop;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShopMapper {
    @Select("select * from shop where owner_id = #{userId}")
    List<Shop> getShopsById(Long userId);

    @Select("select * from shop")
    List<Shop> getAllShops();

    @Insert("insert into shop (owner_id, name) VALUES (#{userId}, #{name})")
    boolean addShop(Long userId, String name);

    @Update("update shop set name = #{name} where id = #{shopId}")
    boolean modifyShop(Long shopId, String name);

    @Delete("delete from shop where id = #{shopId}")
    boolean deleteShop(Integer shopId);
}
