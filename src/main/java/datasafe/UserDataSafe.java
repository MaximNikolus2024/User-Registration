package datasafe;

import entity.User;

public interface UserDataSafe {

    boolean isUsername(String username);

    void saveUser(User user);

    User getUserByUsername(String username);
}
