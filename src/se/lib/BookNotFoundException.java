package se.lib;

public class BookNotFoundException extends Exception {
    private String title;

    BookNotFoundException(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
