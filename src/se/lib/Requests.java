package se.lib;

import java.util.ArrayList;

class Requests {
    private ArrayList<Request> requestsList = new ArrayList<>();

    BookDetails addRequest(BookDetails requestDetails)  {
        Request request = getRequestByName(requestDetails.getTitle());
        if (request == null) {
            requestsList.add(new Request(requestDetails, false));
            request = requestsList.get(requestsList.size()-1);
        }

        BookDetails requestsFulfilled = request.nextRequest();
        if (requestsFulfilled != null) requestsList.remove(request);
        return requestsFulfilled;
    }

    void addLibraryRequest(BookDetails libRequestDetails) {
        requestsList.add(new Request(libRequestDetails, true));
    }


    Request getRequestByName(String bookname) {
        for (Request request : requestsList) {
            if (request.getBookDetails().getTitle().equals(bookname)) return request;
        }
        //TODO RequestNotFoundException
        return null;
    }

}

