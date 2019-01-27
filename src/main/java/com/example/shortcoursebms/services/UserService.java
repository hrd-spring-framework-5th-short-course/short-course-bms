package com.example.shortcoursebms.services;

import com.example.shortcoursebms.models.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    int save(User user);

    int update(User user);

    int delete(Integer id);


}
