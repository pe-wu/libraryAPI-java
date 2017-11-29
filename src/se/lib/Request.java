package se.lib;

class Request {
    private final BookDetails bookDetails;
    private final boolean everBought;
    private int requestsCounter;

    Request(BookDetails bookDetails, boolean everBought) {
        this.bookDetails = bookDetails;
        this.everBought = everBought;
        this.requestsCounter = 0;
    }

    BookDetails getBookDetails() {
        return bookDetails;
    }

    int getRequestsCounter() {
        return requestsCounter;
    }

    BookDetails processRequest() {
        requestsCounter++;
        if (timeToBuyBook()) {
            return bookDetails.copy(); 
        }
        return null;
    }

    private boolean timeToBuyBook() {
        return everBought && requestsCounter == Library.RENEWAL_REQUESTS ||
                requestsCounter == Library.DEFAULT_REQUESTS;
    }
}

