package se.lib;

import java.util.ArrayList;

class Books {
    private ArrayList<Book> books = new ArrayList<>();

    String getBooks() {
        if (books.size() != 0) {
            StringBuilder booksInLibrary = new StringBuilder();
            for (Book b : books) {
                booksInLibrary.append(b.toString()).append("\n");
                return booksInLibrary.toString();
            }
        }
        return "No books in the library!";
    }

    String buyBook(BookDetails bookDetails) {
        books.add(new Book(bookDetails));
        return "Book " + bookDetails + " added to library";
    }

}
