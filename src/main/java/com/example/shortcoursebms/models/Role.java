package com.example.shortcoursebms.models;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {

    private Integer id;

    private String name;

    @Override
    public String getAuthority() {
        return "ROLE_" + name;
    }
}
