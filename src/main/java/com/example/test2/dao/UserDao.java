package com.example.test2.dao;

import com.example.test2.model.User;
import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   User getUserByCar(String mark, int model);
}
