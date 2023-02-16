package com.vitali.animal.dao;

import java.util.List;

public interface Dao<K, T> {
    List<T> findAll();
    T findById(K id);
    void delete(K id);
    void update(T entity, K id);
    T save(T entity);
}
