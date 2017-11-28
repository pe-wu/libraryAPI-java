package se.lib;

public class UserNotFoundException extends Exception {
    private String username;

    UserNotFoundException(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
