package com.malikov.productmanager.service;

import com.malikov.productmanager.model.Product;

import java.util.List;

public interface ProductService {

    Product add(Product product);

    Product update(Product product);

    void delete(int id);

    Product get(int id);

    List<Product> getAll();
}
