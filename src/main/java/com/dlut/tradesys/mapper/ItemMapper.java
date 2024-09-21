package com.dlut.tradesys.mapper;

import com.dlut.tradesys.common.pojo.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ItemMapper {
    @Select("select * from item where name like concat('%',#{keyword},'%') and category = #{category} and status = 1 order by ${orderBy}")
    List<Item> itemSearchWithCategory(String keyword, String category, String orderBy);

    @Select("select * from item where name like concat('%',#{keyword},'%') and status = 1 order by ${orderBy}")
    List<Item> itemSearch(String keyword, String orderBy);
}
