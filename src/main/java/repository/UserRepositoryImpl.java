package repository;

import entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {
    private final Map<String, User> usersDatabase = new HashMap<>();


    @Override
    public boolean isUsername(String login) {
        return usersDatabase.containsKey(login);
        /**добавляет объект user в мапу usersDatabase заменяя старое значение на новое*/

    }

    @Override
    public void saveUser(User user) {
         usersDatabase.put(user.getUserName(), user);
    /**строка добавляет объект User в usersDatabase, используя имя пользователя в качестве ключа.*/
    }

    @Override
    public User getUserByUsername(String login) {
        return usersDatabase.get(login);
        /**Эта строка кода возвращает объект User, связанный с указанным именем пользователя, из базы данных usersDatabase.*/
    }
}


