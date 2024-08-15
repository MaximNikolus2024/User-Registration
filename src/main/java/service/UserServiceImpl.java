package service;

import repository.UserRepository;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    @Override
    public boolean validate(String login, String password) {
        return false;
    }
}