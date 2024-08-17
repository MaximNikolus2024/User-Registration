package service;

import com.google.common.hash.Hashing;
import entity.User;
import repository.UserRepository;

import java.nio.charset.StandardCharsets;


public class UserServiceImpl implements UserService {
    /**
     * Поле, которое хранит ссылку на объект UserRepository.
     */
    private final UserRepository userRepository;

    /**
     * Конструктор класса UserServiceImpl, который принимает объект UserRepository.
     */
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Метод, который проверяет, существует ли пользователь с заданным логином.
     * @return логин true, если пользователь существует, false иначе
     */
    @Override
    public boolean isUserExists(String login) {
        return userRepository.isUserExists(login);
    }
    /**
     * Метод, который сохраняет пользователя в базе данных.
     * @param user пользователь, которого нужно сохранить
     */
    @Override
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }
    /**
     * Метод, который возвращает пользователя по его логину.
     * @param login логин пользователя
     * @return пользователь, если он существует, null иначе
     */
    @Override
    public User getUserByUsername(String login) {
        return userRepository.getUserByUsername(login);
    }
    /**
     * Метод, который проверяет, является ли пароль действительным.
     * @param password пароль, который нужно проверить
     * @return true, если пароль действителен, false иначе
     */
    @Override
    public boolean isValidPassword(String password) {
        return password.length() >= 6
                && password.matches(".*\\d.*") // Наличие цифры
                && password.matches(".*[!@#$%^&*].*") // Наличие специального символа
                && password.matches(".*[A-Z].*"); // Наличие заглавной буквы
    }

    /**
     * Метод, который шифрует пароль используя алгоритм SHA-256.
     * @param password пароль, который нужно шифровать
     * @return зашифрованный пароль
     */
    @Override
    public String encryptPassword(String password) {
        return Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();

}}


