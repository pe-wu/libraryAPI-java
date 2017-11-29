package se.lib;

class BookDetails {
    private final String isbn;
    private final String author;
    private final String title;

    BookDetails(String isbn, String author, String title) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
    }

    String getTitle() {
        return title;
    }

    BookDetails copy() {
        return new BookDetails(this.isbn, this.author, this.title); //clone() not implemented intentionally
    }

    @Override
    public String toString() {
        return isbn + ", " + author + ", " + title;
    }

}
