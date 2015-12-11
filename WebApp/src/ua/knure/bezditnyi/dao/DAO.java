package ua.knure.bezditnyi.dao;

import java.util.List;

/**
 * Created by Artem on 10.12.2015.
 */
public interface DAO<T> {

    public T create(T entity);

    public T getById(int id);

    public void update(T entity);

    public void delete(int id);

    public List<T> getAll();
}
