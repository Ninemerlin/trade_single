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
    List<Spec> getSpec(Integer itemId);

    @Insert("insert into spec (item_id, name) values (#{itemId}, #{name})")
    boolean addSpec(Integer itemId, String name);

    @Delete("delete from spec where id = #{specId}")
    boolean deleteSpec(Integer specId);
}
