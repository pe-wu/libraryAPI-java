package se.lib;

import java.util.ArrayList;

class Requests {
    private ArrayList<Request> requestsList = new ArrayList<>();

    BookDetails addRequest(BookDetails requestDetails)  {
        Request oldRequest = getRequestByName(requestDetails.getTitle());

        if (oldRequest != null) {
            oldRequest.increaseRequestsIndex();
            if (!oldRequest.timeToBuyBook()) return null;
            else {
                BookDetails bookToBuy = oldRequest.getBookDetails().copy(); //clone() not implemented intentionally;
                requestsList.remove(oldRequest);
            }
        }

        //no previous request
        requestsList.add(new Request(requestDetails, false));
        return null;
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

