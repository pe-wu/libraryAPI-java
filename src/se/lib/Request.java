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

    
    void increaseCounter() {
        if(Integer.MAX_VALUE > requestsCounter + 1){
            requestsCounter++;
        }
    }

    BookDetails timeToBuyBook() {
        if (everBought && requestsCounter == Library.RENEWAL_REQUESTS ||
                requestsCounter == Library.DEFAULT_REQUESTS) {
            return bookDetails.copy(); //clone() not implemented intentionally;
        }
        return null;
    }
}

