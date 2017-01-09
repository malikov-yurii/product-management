package com.malikov.productmanager.dao.datajpa;

import com.malikov.productmanager.dao.ProductDAO;
import com.malikov.productmanager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataJpaProductDAO extends JpaRepository<Product, Integer>, ProductDAO{






}
