package com.malikov.productmanager.service;

import com.malikov.productmanager.dao.UserDAO;
import com.malikov.productmanager.model.Role;
import com.malikov.productmanager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.HashSet;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userDAO.findByName(username);
            Set<GrantedAuthority> authorities = new HashSet<>();
            for (Role role : user.getRoles())
                authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
            return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
        }catch (NoResultException e){
            throw new UsernameNotFoundException("User not found by login in db");
        }
    }
}
