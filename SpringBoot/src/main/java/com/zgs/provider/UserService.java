package com.zgs.provider;

import com.zgs.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Smily on 2017/5/5.
 */
@Mapper
public interface UserService {
    @Insert("insert into account(name, money) values(#{name}, #{money})")
    int add(@Param("name") String name, @Param("money") double money);

    @Update("update account set name = #{name}, money = #{money} where id = #{id}")
    int update(@Param("name") String name, @Param("money") double money, @Param("id") int  id);

    @Delete("delete from account where id = #{id}")
    int delete(int id);

    @Select("select id, name as name, money as money from account where id = #{id}")
    User findAccount(@Param("id") int id);

    @Select("select id, name as name, money as money from account")
    List<User> findAccountList();
}
