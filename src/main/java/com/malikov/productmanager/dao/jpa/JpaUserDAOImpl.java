package com.malikov.productmanager.dao.jpa;


import com.malikov.productmanager.dao.UserDAO;
import com.malikov.productmanager.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserDAOImpl extends JpaGenericDAOImpl<User> implements UserDAO{

    @Override
    public User findByName(String name) {
        return em.createQuery("SELECT u FROM User u WHERE u.name=:name", User.class)
                .setParameter("name", name).getSingleResult();
    }
}
