package com.dlut.tradesys.mapper;

import com.dlut.tradesys.common.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    User getUserByUsername(String username);

    @Insert("insert into user (username, nickname, password, user_type, create_time, update_time)" +
            "VALUES (#{username}, #{nickname}, #{password}, #{userType}, #{createTime}, #{updateTime})")
    boolean addUser(User user);

    @Delete("delete from user where id = #{userId}")
    boolean cancel(Long userId);

    @Update("update user set icon = #{url} where id = #{userId}")
    boolean modifyIconPath(Long userId, String url);

    @Select("select * from user where id = #{userId}")
    User getUserById(Long userId);

    @Update("update user set email = #{email} where id = #{userId}")
    boolean modifyMail(Long userId, String email);

    @Update("update user set password = #{password} where id = #{userId}")
    boolean modifyPwd(Long userId, String password);

    // 任意列修改
    @Update("update user set ${column} = #{value} where id = #{userId}")
    boolean setAttribute(Long userId, String column, Object value);

    // 外部service使用
    @Select("select user_type from user where id = #{userId}")
    Integer getUserTypeById(Long userId);
}
