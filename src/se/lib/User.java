package se.lib;

import java.util.ArrayList;

class User {
    private String name;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();
    private ArrayList<Book> bookRequests = new ArrayList<>();

    User(String name) {
        this.name = name;
    }

}
