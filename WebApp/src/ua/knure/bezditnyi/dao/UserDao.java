package ua.knure.bezditnyi.dao;

import ua.knure.bezditnyi.entity.User;

/**
 * Created by Artem on 11.12.2015.
 */
public interface UserDao extends DAO<User>{

    public User getByEmail();

}
