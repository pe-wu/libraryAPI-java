package se.lib;

class RequestNotFoundException extends Exception {
    private String bookname;

    RequestNotFoundException(String bookname) {
        this.bookname = bookname;
    }

    @Override
    public void printStackTrace() {
        //it's not a bug, it's a feature!
        System.err.println("Request for book " + bookname + "not found!");
        super.printStackTrace();
    }

}
