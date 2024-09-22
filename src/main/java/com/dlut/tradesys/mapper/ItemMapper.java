package com.dlut.tradesys.mapper;

import com.dlut.tradesys.common.pojo.Item;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ItemMapper {
    List<Item> itemSearch(String keyword, String category, String orderBy, Integer status, Long shopId);

    @Insert("insert into item (name, price, stock, image, category, brand, sold, status, create_time, update_time, shop_id) values " +
            "(#{name}, #{price}, #{stock}, #{image}, #{category}, #{brand}, #{sold}, #{status}, #{createTime}, #{updateTime}, #{shopId})")
    boolean addItem(Item item);

    @Update("update item set name = #{name}, price = #{price}, stock = #{stock}, image = #{image}, category = #{category}, brand = #{brand}, update_time = #{updateTime} " +
            "where id = #{id}")
    boolean modifyItem(Item item);

    @Delete("delete from item where id = #{itemId}")
    boolean deleteItem(Long itemId);

    // 外部service使用
    @Select("select * from item where id = #{itemId}")
    Item getItemById(Long itemId);

    @Select("select price from item where id = #{itemId}")
    Integer getPriceById(Long itemId);
}
