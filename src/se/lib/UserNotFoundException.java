package se.lib;

/**
 * user of a given name was not found in the database
 */
public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = -6025110778049708545L;
	private String username;

    UserNotFoundException(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
