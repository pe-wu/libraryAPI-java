package se.lib;

public class TooManyBorrowsException extends Exception {
    private String username;

    TooManyBorrowsException(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
