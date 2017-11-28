package se.lib;

public class BookAlreadyBorrowedException extends Exception {
    private String title;

    BookAlreadyBorrowedException(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
