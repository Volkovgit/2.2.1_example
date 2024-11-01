package com.example.test2.service;
import java.util.List;

import com.example.test2.model.User;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User getUserByCar(String mark, int model);
}