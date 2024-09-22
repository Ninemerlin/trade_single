package com.dlut.tradesys.mapper;

import com.dlut.tradesys.common.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Select("select * from order where buyer_id = #{userId}")
    List<Order> getOrder(Long userId);
}
