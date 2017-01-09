package com.malikov.productmanager.dao;

import com.malikov.productmanager.model.User;

public interface UserDAO extends GenericDAO<User>{
    User findByName(String name);
}
