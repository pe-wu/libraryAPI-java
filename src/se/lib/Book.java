package se.lib;

class Book {
    private BookDetails bookDetails;
    private int borrowsIndex;
    private User currentUser;

    Book(BookDetails bookDetails) {
        this.bookDetails = bookDetails;
        this.borrowsIndex = 0;
    }

    BookDetails getBookDetails() {
        return bookDetails;
    }

    int getBorrowsIndex() {
        return borrowsIndex;
    }

    User getCurrentUser() {
        return currentUser;
    }

    void borrowing(User user) {
        if (user.borrowPossible()) {
            if (currentUser == null) {
                this.currentUser = user;
                this.borrowsIndex++;
                user.addBorrowedBook(this);
            }
            //TODO throw BookAlreadyBorrowedException
        }
        //TODO throw BorrowNotPossibleException

    }

    //function named returning instead of return, because return is a keyword
    BookDetails returning() {
        currentUser.removeBorrowedBook(this);
        currentUser = null;
        if (borrowsIndex < Library.BOOK_WEAR) return null;
        else return bookDetails.copy();
    }
}
