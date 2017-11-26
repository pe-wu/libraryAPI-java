package se.lib;

import java.util.ArrayList;

public class Library {
    static final int RENEWAL_REQUESTS = 2;
    static final int NORMAL_REQUESTS = 2;

    private ArrayList<User> users = new ArrayList<>();
    private Books books = new Books();
    private BookRequests bookRequests = new BookRequests();

    public String addUser(String name) {
        int userId = users.size();
        if (users.add(new User(name))) {
            return "User " + name + " added with id=" + userId;
        } else {
            return "Unable to add user";
        }
    }

    public String getBooks() {
        return books.getBooks();
    }

    public String addRequest(String isbn, String author, String title) {
        BookDetails requestDetails = new BookDetails(isbn, author, title);
        BookRequest request = bookRequests.getRequest(requestDetails);
        request.increaseRequestsIndex();

        if(request.timeToBuyBook()) {
            bookRequests.deleteRequest(request);
            return books.buyBook(request.getBookDetails());
        } else {
            return request.toString();
        }
    }

}
