package com.example.eschool_greetgo.mapper;

import com.example.eschool_greetgo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface mapper_main {
    @Select("select * from users")
    List<User> findAll();

    @Insert("INSERT INTO `bot`.`users` (`id`, `email`, `first_name`, `last_name`, `password`) VALUES (#{id}, #{email}, #{first_name}, #{last_name}, #{password});")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    void insert(com.example.eschool_greetgo.model.User user);

    @Select("select * from users where `id` = #{id}")
    User userById(Integer id);

    @Update("UPDATE `bot`.`users` SET `email` = #{email}, `first_name` = #{first_name}, `last_name` = #{last_name}, `password` = #{password} WHERE (`id` = #{id});")
    User update(User user);

    @Delete("DELETE FROM `bot`.`users` WHERE (`id` = #{id});")
    void delete(Integer id);
}