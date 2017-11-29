package se.lib;

/**
 * Request with a given book title was not found in the database.
 */
public class RequestNotFoundException extends Exception {

	private static final long serialVersionUID = -5518199670119852558L;
	private final String title;

    RequestNotFoundException(String title) {
        this.title = title;
    }

    /**
     * @return book title from the query.
     */
    public String getTitle() {
        return title;
    }
}
