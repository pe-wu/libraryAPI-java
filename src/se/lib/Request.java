package se.lib;

class Request {
    private BookDetails bookDetails;
    private int requestsCounter;
    private boolean everBought;

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
    }

    private boolean timeToBuyBook() {
        return everBought && requestsCounter == Library.RENEWAL_REQUESTS ||
                requestsCounter == Library.DEFAULT_REQUESTS;
    }
}

