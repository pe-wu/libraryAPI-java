package se.lib;

import java.util.ArrayList;

class BookRequests {
    private ArrayList<BookRequest> requests = new ArrayList<>();

    BookRequest getRequest(BookDetails requestDetails) {
        for (BookRequest request : requests) {
            if (request.getIsbn().equals(requestDetails.getIsbn())) {
                return request;
            }
        }
        requests.add(new BookRequest(requestDetails));
        return requests.get(requests.size() - 1);
    }

    void deleteRequest(BookRequest request) {
        requests.remove(request);
    }

}

