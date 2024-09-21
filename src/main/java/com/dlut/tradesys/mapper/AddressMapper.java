package com.dlut.tradesys.mapper;

import com.dlut.tradesys.common.pojo.Address;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AddressMapper {
    @Select("select * from address where user_id = #{userId}")
    List<Address> getAddressesById(Long userId);

    @Insert("insert into address (user_id, province, city, town, mobile, street, receiver, is_default) " +
            "VALUES (#{userId}, #{province}, #{city}, #{town}, #{mobile}, #{street}, #{receiver}, #{isDefault})")
    boolean addAddress(Address address);

    @Update("update address set province = #{province}, city = #{city}, town = #{town}, mobile = #{mobile}, street = #{street}, receiver = #{receiver} where id = #{id}")
    boolean modifyAddress(Address address);

    @Delete("delete from address where id = #{addressId}")
    boolean deleteAddress(Integer addressId);

    @Update("update address set is_default = 0 where user_id = #{userId}")
    boolean removeDefaultAddress(Long userId);

    @Update("update address set is_default = 1 where id = #{addressId}")
    boolean setDefaultAddress(Integer addressId);

    @Select("select * from address where user_id = #{userId} and id = #{addressId}")
    Address checkOwnership(Long userId, Integer addressId);
}
