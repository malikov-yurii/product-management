package com.malikov.productmanager.service;

import com.malikov.productmanager.dao.ProductDAO;
import com.malikov.productmanager.model.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ProductServiceImpl implements ProductService {

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

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
}
