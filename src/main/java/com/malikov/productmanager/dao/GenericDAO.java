package com.malikov.productmanager.dao;

import java.util.List;

public interface GenericDAO<T> {

    T save(T product);

    void delete(int id);

    T get(int id);

    List<T> getAll();
}
