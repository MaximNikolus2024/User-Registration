package controller;

import entity.User;
import service.UserService;

import java.util.Scanner;

// Класс, отвечающий за регистрацию и авторизацию пользователей.
public class RegistrationController {

    private final UserService userService; //final гарантирует, что переменные не могут быть изменены извне класса

    private final Scanner scanner;

    /**
     * Конструктор класса.
     *
     * @param userService сервис для работы с пользователями
     * @param scanner     сканер для чтения пользовательского ввода
     */
    public RegistrationController(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }

    /**
     * Метод, запускающий процесс регистрации или авторизации.
     */
    public void start() {
        try {
            // Выводим меню для пользователя
            System.out.println("1. Регистрация\n2. Авторизация");
            // Читаем выбор пользователя
            String choice = scanner.nextLine();
            // Преобразуем выбор пользователя в команду
            UserCommand userCommand = UserCommand.getCommandByValue(choice);

            // Обрабатываем команду пользователя
            switch (userCommand) {
                case SIGNUP:
                    // Регистрация пользователя
                    signUp();
                    break;
                case SIGNIN:
                    // Авторизация пользователя
                    signIn();
                    break;//break позволяет выйти из конструкции switch и предотвратить выполнение лишнего кода.
                default:
                    // Некорректный выбор
                    System.out.println("Некорректный выбор");
            }
        } catch (Exception e) {
            // Обработка исключений
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }

    /**
     * Метод, реализующий регистрацию пользователя.
     */
    private void signUp() {
        // Выводим запрос на ввод имени пользователя
        System.out.print("Введите имя пользователя: ");
        // Читаем имя пользователя
        String login = scanner.nextLine();
        // Выводим запрос на ввод пароля
        System.out.print("Введите пароль: ");
        // Читаем пароль
        String password = scanner.nextLine();

        // Проверяем, существует ли пользователь с таким именем
        if (userService.isUserExists(login)) {
            // Пользователь с таким именем уже существует
            System.out.println("Пользователь с таким именем уже существует");
            return;
        }
        // Проверяем, корректен ли пароль
        if (!userService.isValidPassword(password)) {
            // Некорректный пароль
            System.out.println("Некорректный пароль. Пароль должен содержать \n хотя бы одну цифру, один специальный символ и одну заглавную букву.");
            return;
        }
        // Шифруем пароль
        String encryptedPassword = userService.encryptPassword(password);
        // Создаем нового пользователя
        User user = new User(login, encryptedPassword);
        // Сохраняем пользователя
        userService.saveUser(user);
        // Выводим сообщение об успешной регистрации
        System.out.println("Пользователь успешно зарегистрирован");
    }

    /**
     * Метод, реализующий авторизацию пользователя.
     */
    private void signIn() {
        // Выводим запрос на ввод имени пользователя
        System.out.print("Введите имя пользователя: ");
        // Читаем имя пользователя
        String login = scanner.nextLine();
        // Выводим запрос на ввод пароля
        System.out.print("Введите пароль: ");
        // Читаем пароль
        String password = scanner.nextLine();

        // Проверяем, существует ли пользователь с таким именем
        if (!userService.isUserExists(login)) {
            // Пользователь не существует
            System.out.println("Пользователь не существует");
            return;
        }
        // Получаем пользователя по имени
        User user = userService.getUserByUsername(login);
        // Шифруем пароль
        String encryptedPassword = userService.encryptPassword(password);
        // Проверяем, корректен ли пароль
        if (!user.getPassword().equals(encryptedPassword)) {
            // Некорректный пароль
            System.out.println("Некорректный пароль");
            return;
        }
        // Выводим сообщение об успешной авторизации
        System.out.println("Пользователь успешно авторизован");


    }
}
