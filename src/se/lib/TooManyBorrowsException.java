package se.lib;

public class TooManyBorrowsException extends Exception {

	private static final long serialVersionUID = -3107482928615030489L;
	private String username;

    TooManyBorrowsException(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
