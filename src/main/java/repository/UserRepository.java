package repository;

import entity.User;

public interface UserRepository {
    boolean exists(String username);

    boolean validate(String username, String password);

    // этот метод ищет пользователя по имени в карте users и возвращает объект User если пользователь найден,
    // или null если пользователь не найден
    User findByUsername(String username);

    // этот метод ищет пользователя по имени в карте users и возвращает объект User если пользователь найден,
    // или null если пользователь не найден
    boolean isUserExists(String login);
    void saveUser(User user);
    User getUserByUsername(String login);



}

