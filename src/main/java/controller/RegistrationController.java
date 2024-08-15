package controller;

import java.util.Scanner;

public class RegistrationController {

private Scanner scanner;
    public void start(){
        try {
            System.out.println("1. Регистрация\n2. Авторизация");


          String choice = scanner.nextLine();

            System.out.print("Введите имя пользователя: ");
            String userName = scanner.nextLine();
            System.out.println("Введите пароль: ");
            String password = scanner.nextLine();
          UserCommand userCommand = UserCommand.valueOf(choice);
          switch (userCommand){

          }
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }



    }
}
