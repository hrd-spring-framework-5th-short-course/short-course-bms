package com.example.shortcoursebms.repositories.providers;

import org.apache.ibatis.jdbc.SQL;

public class UserProvider {

    public String getAllUsersProvider() {
        return new SQL(){{
            SELECT("*");
            FROM("tb_user");
        }}.toString();
    }




}
