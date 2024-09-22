package com.dlut.tradesys.mapper;

import com.dlut.tradesys.common.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Select("select * from `order` where buyer_id = #{userId}")
    List<Order> getOrder(Long userId);

    @Insert("insert into `order` (total_price, payment_type, seller_id, buyer_id, shop_id, address, status, create_time) values " +
            "(#{totalPrice}, #{paymentType}, #{sellerId}, #{buyerId}, #{shopId}, #{address}, #{status}, #{createTime})")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id",before = false, resultType = Long.class)
    boolean createOrder(Order order);
}
