package ua.knure.bezditnyi.storage;

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
        storage = new HashMap<Integer, User>();
        storage.put(generateId(), new User("Name0", "Surname0", "email0@qwe.ua", "password0", null));
        storage.put(generateId(), new User("Name1", "Surname1", "email1@qwe.ua", "password1", null));
        storage.put(generateId(), new User("Name2", "Surname2", "email2@qwe.ua", "password2", null));
        storage.put(generateId(), new User("Name3", "Surname3", "email3@qwe.ua", "password3", null));
        storage.put(generateId(), new User("Name4", "Surname4", "email4@qwe.ua", "password4", null));
        storage.put(generateId(), new User("Name5", "Surname5", "email5@qwe.ua", "password5", null));
    }
    
    public User add(User user){
        int id = generateId();
        user.setId(id);
        storage.put(id, user);
        return user;
    }

    public List<User> getAll(){
        return new ArrayList<User>(storage.values());
    }

    private static int generateId(){
        return id.incrementAndGet();
    }
}
