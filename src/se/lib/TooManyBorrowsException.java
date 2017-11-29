package se.lib;

/**
 * User has already reached max. number of borrows specified in the system.
 */
public class TooManyBorrowsException extends Exception {

    private static final long serialVersionUID = -3107482928615030489L;
    private final String username;

    TooManyBorrowsException(String username) {
        this.username = username;
    }

    /**
     * @return username from the command.
     */
    public String getUsername() {
        return username;
    }
}
