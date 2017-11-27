package se.lib;

class BookAlreadyBorrowedException extends Exception {
    private String title;

    BookAlreadyBorrowedException(String title) {
        this.title = title;
    }

    @Override
    public void printStackTrace() {
        //it's not a bug, it's a feature!
        System.err.println("Book " + title + "already borrowed!");
        super.printStackTrace();
    }
}
