package se.lib;

/**
 * User of a given name was not found in the database.
 */
public class UserNotFoundException extends Exception {

    private static final long serialVersionUID = -6025110778049708545L;
    private final String username;

    UserNotFoundException(String username) {
        this.username = username;
    }

    /**
     * @return username from the query.
     */
    public String getUsername() {
        return username;
    }
}
