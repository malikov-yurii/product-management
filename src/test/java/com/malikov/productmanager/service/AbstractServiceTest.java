package com.malikov.productmanager.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({
        "classpath:appconfig-test.xml",
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = {
//    "classpath:db/initTestDB.sql",
        "classpath:db/populateDB.sql"},
        config = @SqlConfig(encoding = "UTF-8"))
public abstract class AbstractServiceTest {
}
