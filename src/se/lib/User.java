package se.lib;

import java.util.ArrayList;

class User {
    private String name;
    private int borrowedBooksIndex = 0;

    User(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void addBorrowedBook() {
        borrowedBooksIndex++;
    }

    void removeBorrowedBook() {
        borrowedBooksIndex--;
    }

    boolean borrowPossible() {
        return borrowedBooksIndex < Library.BORROWS_PER_USER;
    }

}
