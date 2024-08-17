package service;

import entity.User;

public interface UserService {

    boolean isUserExists(String login);

    void saveUser(User user);

    User getUserByUsername(String login);

    boolean isValidPassword(String password);

    String encryptPassword(String password);
}



