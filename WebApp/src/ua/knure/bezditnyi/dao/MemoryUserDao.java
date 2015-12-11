package ua.knure.bezditnyi.dao;

import ua.knure.bezditnyi.storage.UserStorage;
import ua.knure.bezditnyi.entity.User;

import java.util.List;

/**
 * Created by Artem on 11.12.2015.
 */
public class MemoryUserDao implements UserDao {

    private UserStorage storage;

    public MemoryUserDao(UserStorage storage){
        this.storage = storage;
    }

    @Override
    public User create(User entity) {
        return this.storage.add(entity);
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<User> getAll() {
        return storage.getAll();
    }

    @Override
    public User getByEmail() {
        return null;
    }
}
