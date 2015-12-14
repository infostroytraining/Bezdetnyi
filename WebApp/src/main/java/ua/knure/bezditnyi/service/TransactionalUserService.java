package ua.knure.bezditnyi.service;

import ua.knure.bezditnyi.dao.exception.DaoException;
import ua.knure.bezditnyi.dao.interfaces.UserDao;
import ua.knure.bezditnyi.db.Transaction;
import ua.knure.bezditnyi.db.TransactionManager;
import ua.knure.bezditnyi.db.exception.TransactionException;
import ua.knure.bezditnyi.entity.User;
import ua.knure.bezditnyi.service.exception.ServiceException;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Artem on 13.12.2015.
 */
public class TransactionalUserService implements UserService{

    private TransactionManager transactionManager;
    private UserDao userDao;

    public TransactionalUserService(TransactionManager manager, UserDao userDao){
        this.transactionManager = manager;
        this.userDao = userDao;
    }

    @Override
    public User registerUser(final User user) throws ServiceException {
        try {
            return transactionManager.doTask(new Transaction<User>() {
                @Override
                public User execute() throws DaoException {
                    return userDao.insert(user);
                }
            }, Connection.TRANSACTION_READ_COMMITTED);
        } catch (TransactionException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getAll() throws ServiceException {
        return null;
    }
}
