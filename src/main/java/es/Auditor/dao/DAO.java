package es.auditor.dao;

import java.util.*;

public interface DAO<T> {
    Optional<T> findById(int id);
    List<T> findAll();
    void insert(T entity);
    void update(T entity);
    void delete(int id);
}
