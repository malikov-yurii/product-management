package com.malikov.productmanager.service;

import com.malikov.productmanager.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    User findByName(String name);

    List<User> getAll();
}
