package com.kidunion.repositories;

import java.util.List;

public interface CrudGeneric<T> {
    List<T> findAll();
    void save(T entity);
    void delete(Long id);
    T update(T entity);
}
