package com.malikov.productmanager.service;

import com.malikov.productmanager.model.User;

public interface UserService {

    void save(User user);

    User findByName(String name);

}
