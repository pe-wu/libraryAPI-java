package se.lib;

import static se.lib.Library.RENEWAL_REQUESTS;

public class BookRequest {
    private BookDetails bookDetails;
    private boolean everBought;
    private int requestsIndex;

    BookRequest(BookDetails bookDetails) {
        this.bookDetails = bookDetails;
        this.everBought = false;
        requestsIndex = 0;
    }

//    BookRequest(BookDetails bookDetails, boolean everBought) {
//        this.bookDetails = bookDetails;
//        this.everBought = everBought;
//    }

    @Override
    public String toString() {
        return "Request: " + bookDetails.toString();
    }

    String getIsbn() {
        return bookDetails.getIsbn();
    }

    void increaseRequestsIndex() {
        requestsIndex++;
    }

    boolean timeToBuyBook() {
        return everBought && requestsIndex == RENEWAL_REQUESTS ||
                requestsIndex == Library.NORMAL_REQUESTS;
    }

    BookDetails getBookDetails() {
        return bookDetails;
    }
}

