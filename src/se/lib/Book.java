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

    User getCurrentUser() throws CurrentUserNotFoundException {
        if (currentUser != null) {
            return currentUser;
        }
        throw new CurrentUserNotFoundException(bookDetails.getTitle());
    }

    // benenne in borrowByUser um
    void borrowing(User user) throws BookAlreadyBorrowedException, TooManyBorrowsException {
        if (user.borrowPossible()) {
            if (currentUser == null) {
                this.currentUser = user;
                this.borrowsIndex++;
                user.addBorrowedBook();
            }
            throw new BookAlreadyBorrowedException(getBookDetails().getTitle());
        }
        throw new TooManyBorrowsException(user.getName());

    }

    //bennene in returnByUser
    //function named returning instead of return, because return is a keyword
    BookDetails returning() {
        currentUser.removeBorrowedBook();
        currentUser = null;
        if (borrowsIndex < Library.BOOK_WEAR) return null;
        else return bookDetails.copy();
    }
}
