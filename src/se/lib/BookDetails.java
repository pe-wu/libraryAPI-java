package se.lib;

class BookDetails {
    private String isbn;
    private String author;
    private String title;

    BookDetails(String isbn, String author, String title) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
    }

    String getTitle() {
        return title;
    }

    BookDetails copy() {
        return new BookDetails(this.isbn, this.author, this.title);
    }

    @Override
    public String toString() {
        return isbn + ", " + author + ", " + title;
    }

}
