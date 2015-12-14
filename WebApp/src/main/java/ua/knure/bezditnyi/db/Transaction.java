package ua.knure.bezditnyi.db;

import ua.knure.bezditnyi.dao.exception.DaoException;

/**
 * Created by Artem on 13.12.2015.
 */
public interface Transaction<T> {

    public T execute() throws DaoException;
}
