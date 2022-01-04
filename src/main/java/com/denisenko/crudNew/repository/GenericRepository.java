package com.denisenko.crudNew.repository;

import java.util.List;

public interface GenericRepository<T,ID> {
    T getById(ID id) ;
    T save(T t);
    void deleteById(ID id);
    List<T> getAll();
    T update(T t);
}
