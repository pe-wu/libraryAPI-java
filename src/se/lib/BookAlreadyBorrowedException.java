package se.lib;

/**
 * Book unable to be borrowed because there is another user already set as borrower.
 */
public class BookAlreadyBorrowedException extends Exception {

    private static final long serialVersionUID = -8450482463776589965L;
    private final String title;

    BookAlreadyBorrowedException(String title) {
        this.title = title;
    }

    /**
     * @return book title from the command.
     */
    public String getTitle() {
        return title;
    }

}
