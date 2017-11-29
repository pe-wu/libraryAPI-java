package se.lib;

import java.util.ArrayList;

class Requests {
    private ArrayList<Request> requestsList = new ArrayList<>();

    BookDetails addRequest(BookDetails requestDetails, boolean everBought) {
        Request request = getRequest(requestDetails, everBought);
        BookDetails requestsFulfilled = request.processRequest();
        if (requestsFulfilled != null) {
            requestsList.remove(request);
        }
        return requestsFulfilled;
    }

    private Request getRequest(BookDetails requestDetails, boolean everBought) {
        try {
            return getRequestByTitle(requestDetails.getTitle());
        } catch (RequestNotFoundException e) {
            requestsList.add(new Request(requestDetails, everBought));
            return requestsList.get(requestsList.size()-1);
        }
    }

    Request getRequestByTitle(String booktitle) throws RequestNotFoundException {
        for (Request request : requestsList) {
            if (request.getBookDetails().getTitle().equals(booktitle)) {
                return request;
            }
        }
        throw new RequestNotFoundException(booktitle);
    }

}

