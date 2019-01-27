package com.example.shortcoursebms.repositories;

import com.example.shortcoursebms.models.Role;
import com.example.shortcoursebms.models.User;
import com.example.shortcoursebms.repositories.providers.UserProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    @Select("select * from tb_user where username = #{usernameOrEmail} OR email = #{usernameOrEmail}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "id", property = "roles", many = @Many(select = "com.example.shortcoursebms.repositories.RoleRepository.getRoleByUserId"))
    })
    User loadUserByUsername(@Param("usernameOrEmail") String usernameOrEmail);




//    @Select("select *, created_at as createdAt from tb_user")
//    @Select("select * from tb_user")
    // mapping database fields name with properties class (only name not exactly the same)
    @Results({
            @Result(column = "created_at", property = "createdAt")
    })
    @SelectProvider(type = UserProvider.class, method = "getAllUsersProvider")
    List<User> getAllUsers();

    @Insert("insert into tb_user(username,fullname,gender,email) values(#{username}," +
            " #{fullName}, #{gender}, #{email})")
    int save(User user);

    @Update("update tb_user set username = #{p_user.username}, " +
            "fullname = #{p_user.fullName}, gender=#{p_user.gender}, email=#{p_user.email} " +
            "where id = #{p_user.id}")
    int update(@Param("p_user") User user);

    @Delete("delete from tb_user where id = #{id}")
    int delete(@Param("id") Integer id);


}
