package service;

import entity.User;
import org.junit.jupiter.api.Test;
import repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    @Test
    public void testEncryptPasswordValidInput() {

        UserRepository userRepository = new UserRepository() {
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
        };

        UserServiceImpl userService = new UserServiceImpl(userRepository);

        // тест на правильный пароль
        String password = "Password1!";
        String encryptedPassword = userService.encryptPassword(password);

        // Проверяем, что хеш имеет длину 64 символа
        assertEquals(64, encryptedPassword.length(), "Хеш должен быть длиной 64 символа");


    }

    @Test
    public void testEncryptPasswordWithNull() {

        UserRepository userRepository = new UserRepository() {
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
        };
        UserServiceImpl userService = new UserServiceImpl(userRepository);

        // Негативный тест на передачу null
        assertThrows(IllegalArgumentException.class, () -> {
            userService.encryptPassword(null);// null, означая, что пользователь с таким логином не найден.
        });


    }}