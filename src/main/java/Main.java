import controller.RegistrationController;
import repository.UserRepository;
import repository.UserRepositoryImpl;
import service.UserService;
import service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            UserRepository userRepository = new UserRepositoryImpl();
            UserService userService = new UserServiceImpl(userRepository);
            Scanner scanner = new Scanner(System.in);
            RegistrationController registrationController = new RegistrationController(userService, scanner);
            while (true) {
                registrationController.start();
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
    }

