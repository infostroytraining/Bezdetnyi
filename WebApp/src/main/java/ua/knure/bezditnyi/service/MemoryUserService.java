package ua.knure.bezditnyi.service;

import ua.knure.bezditnyi.dao.exception.DaoException;
import ua.knure.bezditnyi.dao.interfaces.UserDao;
import ua.knure.bezditnyi.entity.User;
import ua.knure.bezditnyi.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Artem on 13.12.2015.
 */
public class MemoryUserService implements UserService{

    private UserDao userDao;

    public MemoryUserService(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public User registerUser(User user) throws ServiceException {
        try {
            return userDao.insert(user);
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getAll() throws ServiceException {
        try {
            return userDao.getAll();
        } catch (DaoException e){
            throw new ServiceException(e);
        }
    }
}
