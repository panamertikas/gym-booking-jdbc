package com.gymbooking.dao;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {
    void add(T t);
    void update(T t);
    void delete(T t);
    List<T> getAll();
    Optional<T> getById(int id);
}
