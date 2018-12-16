package com.example.shortcoursebms.services.impl;

import com.example.shortcoursebms.models.User;
import com.example.shortcoursebms.repositories.UserRepository;
import com.example.shortcoursebms.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.getAllUsers();
    }

    @Override
    public int save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public int update(User user) {
        return this.userRepository.update(user);
    }

    @Override
    public int delete(Integer id) {
        return this.userRepository.delete(id);
    }
}
