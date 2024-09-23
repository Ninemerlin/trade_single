package com.dlut.tradesys.mapper;

import com.dlut.tradesys.common.pojo.OrderDetail;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    @Insert("insert into order_detail (order_id, item_id, amount, name, spec, price, image) VALUES " +
            "(#{orderId}, #{itemId}, #{amount}, #{name}, #{spec}, #{price}, #{image})")
    boolean createOrderDetail(OrderDetail orderDetail);

    @Delete("delete from order_detail where order_id = #{orderId}")
    boolean deleteOrderDetailByOrderId(Long orderId);

    @Select("select * from order_detail where order_id = #{orderId}")
    List<OrderDetail> getOrderDetail(Long orderId);
}
