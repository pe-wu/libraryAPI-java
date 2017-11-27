package se.lib;

import java.util.ArrayList;

class User {
    private String name;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    User(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    boolean borrowPossible() {
        return borrowedBooks.size() < Library.BORROWS_PER_USER;
    }

}
