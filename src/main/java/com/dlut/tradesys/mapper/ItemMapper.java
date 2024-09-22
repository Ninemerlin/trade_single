package com.dlut.tradesys.mapper;

import com.dlut.tradesys.common.pojo.Item;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    List<Item> itemSearch(String keyword, String category, String orderBy, Integer status, Long shopId);

    @Insert("insert into item (name, price, stock, image, category, brand, sold, status, create_time, update_time, shop_id) values " +
            "(#{name}, #{price}, #{stock}, #{image}, #{category}, #{brand}, #{sold}, #{status}, #{createTime}, #{updateTime}, #{shopId})")
    boolean addItem(Item item);
}
