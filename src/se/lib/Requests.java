package se.lib;

import java.util.ArrayList;

class Requests {
    private ArrayList<Request> requestsList = new ArrayList<>();

    BookDetails addUserRequest(BookDetails requestDetails)  {
        Request request;
        try {
            request = getRequestByTitle(requestDetails.getTitle());
        } catch (RequestNotFoundException e) {
            requestsList.add(new Request(requestDetails, false));
            request = requestsList.get(requestsList.size()-1);
        }

        request.increaseCounter;
        BookDetails requestsFulfilled = request.timeToBuyBook();
        if (requestsFulfilled != null) requestsList.remove(request);
        return requestsFulfilled;
    }

    void addLibraryRequest(BookDetails libRequestDetails) {
        requestsList.add(new Request(libRequestDetails, true));
    }

    Request getRequestByTitle(String bookname) throws RequestNotFoundException {
        for (Request request : requestsList) {
            if (request.getBookDetails().getTitle().equals(bookname)) return request;
        }
        throw new RequestNotFoundException(bookname);
    }

}

