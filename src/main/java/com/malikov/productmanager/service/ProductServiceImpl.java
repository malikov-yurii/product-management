package com.malikov.productmanager.service;

import com.malikov.productmanager.dao.ProductDAO;
import com.malikov.productmanager.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    @Override
    @Transactional
    public void add(Product product) {
        productDAO.save(product);
    }

    @Override
    @Transactional
    public void update(Product product) {
        productDAO.save(product);
    }

    @Override
    @Transactional
    public void delete(int id) {
        productDAO.delete(id);
    }

    @Override
    @Transactional
    public Product get(int id) {
        return productDAO.get(id);
    }

    @Override
    @Transactional
    public List<Product> getAll() {
        return productDAO.getAll();
    }
}
