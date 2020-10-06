package com.siekny.articleresful.repository;

import com.siekny.articleresful.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    @Select("SELECT * FROM tb_user")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "createdDate", column = "created_date"),
    })
    List<User> getAllUsers();

    @Select("SELECT * FROM tb_user WHERE user_id=#{id}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "profile", column = "profile"),
            @Result(property = "createdDate", column = "created_date"),
    })
    User getOneUser(int id);

    @Select("SELECT * FROM tb_user WHERE email=#{email}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "profile", column = "profile"),
            @Result(property = "createdDate", column = "created_date"),
    })
    User getUserByEmail(String email);

    @Delete("DELETE FROM tb_user WHERE user_id=#{id}")
    Boolean deleteUser(int id);

    @Update("UPDATE tb_user SET user_name=#{user.userName}, email=#{user.email}, profile=#{user.profile} WHERE user_id=#{id}")
    Boolean updateUser(int id, User user);

    @Insert("INSERT INTO tb_user(user_name, email, profile) VALUES (#{userName}, #{email}, #{profile})")
    Boolean addUser(User user);
}
