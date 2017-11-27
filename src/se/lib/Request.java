package se.lib;

class Request {
    private BookDetails bookDetails;
    private boolean everBought;
    private int requestsIndex;

    Request(BookDetails bookDetails, boolean everBought) {
        this.bookDetails = bookDetails;
        this.everBought = everBought;
        this.requestsIndex = 0;
    }

    BookDetails getBookDetails() {
        return bookDetails;
    }

    int getRequestsIndex() {
        return requestsIndex;
    }

    void increaseRequestsIndex() {
        requestsIndex++;
    }

    private boolean timeToBuyBook() {
        return everBought && requestsIndex == Library.RENEWAL_REQUESTS ||
                requestsIndex == Library.NORMAL_REQUESTS;
    }

    BookDetails nextRequest() {
        requestsIndex++;
        if (timeToBuyBook()) {
            return bookDetails.copy(); //clone() not implemented intentionally;
        }
        return null;

    }
}

