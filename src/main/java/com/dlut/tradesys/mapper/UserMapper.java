package com.dlut.tradesys.mapper;

import com.dlut.tradesys.common.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    User getUserByUsername(String username);

    @Insert("insert into user (username, password, create_time, update_time)" +
            "VALUES (#{username}, #{password}, #{createTime}, #{updateTime})")
    boolean addUser(User user);

    @Delete("delete from user where id = #{userId}")
    boolean cancel(Long userId);
}
