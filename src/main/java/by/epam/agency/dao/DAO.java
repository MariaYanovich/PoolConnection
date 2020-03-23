package by.epam.agency.dao;

import java.util.List;

public interface DAO<T> {
    void insert(T entity);

    T getById(int id);

    void update(T entity);

    void delete(T entity);

    List<T> getAll();
}
