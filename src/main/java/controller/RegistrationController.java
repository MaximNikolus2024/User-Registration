package controller;

import service.UserService;

import java.util.Scanner;

public class RegistrationController {

    private Scanner scanner;
    private UserService userService;

    public RegistrationController(Scanner scanner, UserService userService) {
        this.scanner = scanner;
        this.userService = userService;
    }
     public void startProgram() {
        while (true){
            String commandLine = scanner.nextLine();
            UserCommand userCommand = UserCommand.valueOf(commandLine);

            switch(userCommand){
                case SIGNUP -> signUp();
            }
        }
     }

     public void signUp(){
         System.out.println("Для регистрации введите логин и пароль.");

         String data = scanner.nextLine();
     }
}
