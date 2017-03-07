package com.malikov.productmanager.service;

import com.malikov.productmanager.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static com.malikov.productmanager.UserTestData.*;
import static com.malikov.productmanager.model.Role.ROLE_USER;

public class UserServiceImplTest extends AbstractServiceTest {

    @Autowired
    protected UserService service;

    @Test
    public void save() throws Exception {
        User newUser = new User("newUserNamer", "newPassword", ROLE_USER);
        User created = service.save(newUser);
        newUser.setId(created.getId());
        MATCHER.assertCollectionEquals(
                Arrays.asList(USER, ADMIN, newUser),
                service.getAll());
    }

    @Test
    public void findByName() throws Exception {
        User admin = service.findByName(ADMIN.getName());
        MATCHER.assertEquals(ADMIN, admin);
    }
}