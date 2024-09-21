package com.dlut.tradesys.mapper;

import com.dlut.tradesys.common.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    User getUserByUsername(String username);

    @Insert("insert into user (username, password, create_time, update_time)" +
            "VALUES (#{username}, #{password}, #{createTime}, #{updateTime})")
    boolean addUser(User user);

    @Delete("delete from user where id = #{userId}")
    boolean cancel(Long userId);

    @Update("update user set icon = #{url} where id = #{id}")
    boolean modifyIconPath(Long id, String url);
}
