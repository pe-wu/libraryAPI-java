package se.lib;

public class BookAlreadyBorrowedException extends Exception {

	private static final long serialVersionUID = -8450482463776589965L;
	private String title;

    BookAlreadyBorrowedException(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
