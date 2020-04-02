package by.epam.agency.dao;

import by.epam.agency.exception.DAOException;

import java.util.List;

public interface DAO<T> {
    void create(T item) throws DAOException;

    void delete(T item) throws DAOException;

    void delete(int id) throws DAOException;

    T findById(int id) throws DAOException;

    List<T> getAll() throws DAOException;

    void update(T item) throws DAOException;
}
