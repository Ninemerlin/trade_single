package com.dlut.tradesys.mapper;

import com.dlut.tradesys.common.pojo.Order;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface OrderMapper {
    @Select("select * from `order` where buyer_id = #{userId}")
    List<Order> getOrder(Long userId);

    @Insert("insert into `order` (total_price, payment_type, seller_id, buyer_id, shop_id, address, status, create_time) values " +
            "(#{totalPrice}, #{paymentType}, #{sellerId}, #{buyerId}, #{shopId}, #{address}, #{status}, #{createTime})")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id",before = false, resultType = Long.class)
    boolean createOrder(Order order);

    @Delete("delete from `order` where id = #{orderId}")
    boolean deleteOrder(Long orderId);

    @Update("update `order` set status = #{status} where id = #{orderId}")
    boolean setOrderStatus(Long orderId, Integer status);

    @Select("select status from `order` where id = #{orderId}")
    Integer getOrderStatus(Long orderId);

    @Update("update `order` set pay_time = #{payTime} where id = #{orderId}")
    void setPayTime(Long orderId, LocalDateTime payTime);

    @Update("update `order` set consign_time = #{consignTime} where id = #{orderId}")
    void setConsignTime(Long orderId, LocalDateTime consignTime);

    @Update("update `order` set end_time = #{endTime} where id = #{orderId}")
    void setEndTime(Long orderId, LocalDateTime endTime);
}
