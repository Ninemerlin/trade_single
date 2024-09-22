package com.dlut.tradesys.mapper;

import com.dlut.tradesys.common.pojo.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    List<Item> itemSearch(String keyword, String category, String orderBy, Integer status, Long shopId);
}
