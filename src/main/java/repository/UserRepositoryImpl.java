package repository;

import entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

    private final Map<String, User> usersDatabase = new HashMap<>();



    @Override
    public boolean isUserExists(String login) {
        return usersDatabase.containsKey(login);
    }

    @Override
    public void saveUser(User user) {
        usersDatabase.put(user.getLogin(), user);
    }

    @Override
    public User getUserByUsername(String login) {
        return usersDatabase.get(login);


    }}


