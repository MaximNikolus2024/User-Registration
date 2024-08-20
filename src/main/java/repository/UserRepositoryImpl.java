package repository;

import entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

    private final Map<String, User> usersDatabase = new HashMap<>();

    public void save(User user) {
        // Сохранение пользователя
        // Убедитесь, что пользователь не существует перед сохранением
        if (exists(user.getLogin())) {
            System.out.println("Пользователь уже существует: " + user.getLogin());
            return; // Не сохраняем, если пользователь уже есть
        }
        // Сохранение пользователя
        usersDatabase.put(user.getLogin(), usersDatabase.getPassword());
    }

    @Override
    public boolean exists(String username) {
        // Проверка существования пользователя в хранилище
        return usersDatabase.containsKey(username);
    }

    @Override
    public boolean validate(String username, String password) {

        // Проверка  сохраненного пароля
        // Здесь используется метод get у Map, чтобы извлечь сохраненный пароль для указанного имени пользователя (username).

        String storedPassword = usersDatabase.get(username);


        //это условие сравнивает введенный пользователем пароль с сохраненным паролем. Если они совпадают,
        //  это означает, что пользователь ввел правильный пароль.
        //  Если пользователь с таким именем не существует, storedPassword будет равно null.
        boolean isValid = storedPassword != null && password.equals(storedPassword);

        // Логирование результата проверки Это для отладки и мониторинга,
        // так как позволяет видеть, какие пользователи проходят проверку, а какие нет.
        System.out.println("Проверка пользователя: " + username + ", результат: " + isValid);
        return isValid;

    }
    // этот метод ищет пользователя по имени в карте users и возвращает объект User если пользователь найден,
    // или null если пользователь не найден
    @Override
    public User findByUsername(String username) {
        String password = usersDatabase.get(username);
        if (password!= null) {
            return new User(username, password);
        } else {
            return null;
        }}

    @Override
    public boolean isUserExists(String login) {
        return false;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User getUserByUsername(String login) {
        return null;
    }
}

}