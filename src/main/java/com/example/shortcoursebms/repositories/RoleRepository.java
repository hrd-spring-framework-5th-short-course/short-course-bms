package com.example.shortcoursebms.repositories;

import com.example.shortcoursebms.models.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository {

    @Select("select r.id, r.name from tb_role r " +
            "inner join tb_user_role ur on r.id = ur.role_id " +
            "where ur.user_id = #{id}")
    List<Role> getRoleByUserId(Integer id);
}
