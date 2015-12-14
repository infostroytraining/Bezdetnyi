package ua.knure.bezditnyi.dao.interfaces;

import ua.knure.bezditnyi.dao.exception.DaoException;

import java.util.List;

/**
 * Created by Artem on 10.12.2015.
 */
public interface DAO<E> {

    public E create() throws DaoException;
    
    public E insert(E entity) throws DaoException;

    public E getById(int id) throws DaoException;

    public void update(E entity) throws DaoException;

    public void delete(int id) throws DaoException;

    public List<E> getAll() throws DaoException;
}
