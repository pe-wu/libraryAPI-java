package se.lib;

public class BookNotFoundException extends Exception {

	private static final long serialVersionUID = -7215518272267492347L;
	private String title;

    BookNotFoundException(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
