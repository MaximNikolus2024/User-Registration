package repository;

import entity.User;

public interface UserRepository {

    boolean isUsername(String login);

    void saveUser(User user);

    User getUserByUsername(String login);
}
