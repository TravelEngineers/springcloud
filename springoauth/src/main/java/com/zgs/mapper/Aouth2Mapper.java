package com.zgs.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Shmily on 2017/5/31.
 * mybatis 使用demo
 */
//@Mapper
public interface Aouth2Mapper {
    @Insert("insert into account(name, money) values(#{name}, #{money})")
    int add(@Param("name") String name, @Param("money") double money);

    @Update("update account set name = #{name}, money = #{money} where id = #{id}")
    int update(@Param("name") String name, @Param("money") double money, @Param("id") int  id);

    @Delete("delete from account where id = #{id}")
    int delete(int id);

    @Select("select id, name as name, money as money from account where id = #{id}")
    Map<String,Object> findAccount(@Param("id") int id);

    @Select("select id, name as name, money as money from account")
    List<Map<String,Object>> findAccountList();
}
