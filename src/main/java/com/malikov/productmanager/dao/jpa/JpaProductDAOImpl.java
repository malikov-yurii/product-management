package com.malikov.productmanager.dao.jpa;

import com.malikov.productmanager.dao.ProductDAO;
import com.malikov.productmanager.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public class JpaProductDAOImpl extends JpaGenericDAOImpl<Product> implements ProductDAO {

}
