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

    int getRequestsIndex() {
        return requestsCounter;
    }

    //One function does one thing! Ich würde es in zwei Funktionen teilen
    //die erste würde ich als increaseDemand umbenennen
    BookDetails nextRequest() {
        requestsCounter++;
        if (timeToBuyBook()) {
            return bookDetails.copy(); //clone() not implemented intentionally;
        }
        return null;
    }

    private boolean timeToBuyBook() {
        return everBought && requestsCounter == Library.RENEWAL_REQUESTS ||
                requestsCounter == Library.DEFAULT_REQUESTS;
    }
}

