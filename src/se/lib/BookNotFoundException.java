package se.lib;

class BookNotFoundException extends Exception {
    private String bookname;

    BookNotFoundException(String bookname) {
        this.bookname = bookname;
    }

    @Override
    public void printStackTrace() {
        //it's not a bug, it's a feature!
        System.err.println("Book " + bookname + "not found!");
        super.printStackTrace();
    }

}
