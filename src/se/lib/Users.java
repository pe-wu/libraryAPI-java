package se.lib;

import java.util.ArrayList;

class Users {
    private final ArrayList<User> usersList = new ArrayList<>();

    void add(String username) {
        usersList.add(new User(username));
    }

    User findUserByName(String username) throws UserNotFoundException {
        for (User user : usersList) {
            if (user.getName().equals(username)) {
                return user;
            }
        }
        throw new UserNotFoundException(username);
    }
}
