package ua.knure.bezditnyi.dao.interfaces;

import ua.knure.bezditnyi.dao.exception.DaoException;
import ua.knure.bezditnyi.entity.User;

/**
 * Created by Artem on 11.12.2015.
 */
public interface UserDao extends DAO<User>{

    public User getByEmail(String email) throws DaoException;

}
