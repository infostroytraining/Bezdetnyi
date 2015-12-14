package ua.knure.bezditnyi.service;

import ua.knure.bezditnyi.entity.User;
import ua.knure.bezditnyi.service.exception.ServiceException;

import java.util.List;

/**
 * Created by Artem on 11.12.2015.
 */
public interface UserService {

    public User registerUser(User user) throws ServiceException;

    public List<User> getAll() throws ServiceException;
}
