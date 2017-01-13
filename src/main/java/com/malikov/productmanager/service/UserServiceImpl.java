package com.malikov.productmanager.service;

import com.malikov.productmanager.dao.UserDAO;
import com.malikov.productmanager.model.Role;
import com.malikov.productmanager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    @Transactional
    public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(Collections.singletonList(Role.ROLE_USER)));
        userDAO.save(user);
    }

    @Override
    @Transactional
    public User findByName(String name) {
        return userDAO.findByName(name);
    }
}
