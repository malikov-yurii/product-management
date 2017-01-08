package com.malikov.productmanager.dao;


import com.malikov.productmanager.model.Product;

import java.util.List;

public interface ProductDAO  {

    void add(Product product);

    void update(Product product);

    void delete(int id);

    Product get(int id);

    List<Product> getAll();
}
