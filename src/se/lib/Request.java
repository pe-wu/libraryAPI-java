package se.lib;

class Request {
    private BookDetails bookDetails;
    private int requestsIndex;
    private boolean everBought;

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

    //One function does one thing! Ich würde es in zwei Funktionen teilen
    //die erste würde ich als increaseDemand umbenennen
    BookDetails nextRequest() {
        requestsIndex++;
        if (timeToBuyBook()) {
            return bookDetails.copy(); //clone() not implemented intentionally;
        }
        return null;
    }

    private boolean timeToBuyBook() {
        return everBought && requestsIndex == Library.RENEWAL_REQUESTS ||
                requestsIndex == Library.DEFAULT_REQUESTS;
    }
}

