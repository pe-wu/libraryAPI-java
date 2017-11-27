package se.lib;

import java.util.ArrayList;

class Users {
    private ArrayList<User> usersList = new ArrayList<>();

    void add(String username) {
        usersList.add(new User(username));
    }

    User getUserByName(String username) {
        for (User user : usersList) {
            if (user.getName().equals(username)) return user;
        }
        return null;
        //TODO UserNotFoundException(username);
    }
}
