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

    void borrow(User user) {
        if (user.borrowPossible()) {
            this.currentUser = user;
            this.borrowsIndex++;
            user.addBorrowedBook(this);
        } else {
            //TODO throw BorrowNotPossibleException
        }
    }

    void removeUser() {
        this.currentUser = null;
    }
}
