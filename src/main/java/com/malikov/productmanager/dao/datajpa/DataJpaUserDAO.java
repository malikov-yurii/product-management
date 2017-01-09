package com.malikov.productmanager.dao.datajpa;

import com.malikov.productmanager.dao.UserDAO;
import com.malikov.productmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataJpaUserDAO extends JpaRepository<User, Integer>, UserDAO {
}
