package ua.knure.bezditnyi.dao.implementation;

import ua.knure.bezditnyi.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Artem on 10.12.2015.
 */
public class UserStorage {

    private static Map<Integer, User> storage;
    private static AtomicInteger id = new AtomicInteger();

    public UserStorage(){
        storage = new HashMap<>();
        for(int i = 0; i < 5; i++){
            User user = new User("Name" + i, "Surname" + i,
                    i + "email@email.ua", "password" + i);
            int id = generateId();
            user.setId(id);
            storage.put(id, user);
        }
    }
    
    public User add(User user){
        int id = generateId();
        user.setId(id);
        storage.put(id, user);
        return user;
    }

    public User create(){
        int id = generateId();
        return new User(id);
    }

    public List<User> getAll(){
        return new ArrayList<>(storage.values());
    }

    private static int generateId(){
        return id.incrementAndGet();
    }
}
