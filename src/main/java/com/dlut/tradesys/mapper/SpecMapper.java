package com.dlut.tradesys.mapper;

import com.dlut.tradesys.common.pojo.Spec;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SpecMapper {
    @Select("select * from spec where item_id = #{itemId}")
    List<Spec> getSpec(Long itemId);

    @Insert("insert into spec (item_id, name) values (#{itemId}, #{name})")
    boolean addSpec(Long itemId, String name);

    @Delete("delete from spec where id = #{specId}")
    boolean deleteSpec(Long specId);

    // 外部service使用
    @Select("select name from spec where id = #{specId}")
    String getSpecById(Long specId);
}
