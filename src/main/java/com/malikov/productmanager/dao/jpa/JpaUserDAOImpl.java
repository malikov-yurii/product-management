package com.malikov.productmanager.dao.jpa;


import com.malikov.productmanager.dao.UserDAO;
import com.malikov.productmanager.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

@Repository
public class JpaUserDAOImpl extends JpaGenericDAOImpl<User> implements UserDAO{

    @Override
    public User findByName(String name) {
        User user = null;
        Query query = em.createQuery("SELECT u FROM User u WHERE u.name=:name", User.class)
                .setParameter("name", name);
        try {
            if (query.getResultList().size() != 0) {
                user = (User) query.getSingleResult();
            }
        } catch (NoResultException e) {
//            LOG.error("Cannot find entity by name: " + name);
        } catch (NonUniqueResultException e) {
//            LOG.error("Error! Name should be unique! Several entities has been found by name: " + name);
        }
        return user;
    }
}
