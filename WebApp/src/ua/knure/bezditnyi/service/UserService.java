package ua.knure.bezditnyi.service;

import ua.knure.bezditnyi.dao.UserDao;
import ua.knure.bezditnyi.entity.User;

import java.util.List;

/**
 * Created by Artem on 11.12.2015.
 */
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public User registerUser(User user){
        return userDao.create(user);
    }

    public List<User> getAll(){
        return userDao.getAll();
    }
}
