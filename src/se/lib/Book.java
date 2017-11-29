package se.lib;

class Book {
    private final BookDetails bookDetails;
    private int borrowsCounter;
    private User currentUser;

    Book(BookDetails bookDetails) {
        this.bookDetails = bookDetails;
        this.borrowsCounter = 0;
    }

    BookDetails getBookDetails() {
        return bookDetails;
    }

    int getBorrowsCounter() {
        return borrowsCounter;
    }

    User getCurrentUser() throws UserNotFoundException {
        if (currentUser != null) {
            return currentUser;
        }
        throw new UserNotFoundException(bookDetails.getTitle());
    }

    void processBorrow(User user) throws BookAlreadyBorrowedException, TooManyBorrowsException {
        if (user.borrowPossible()) {
            if (currentUser == null) {
                this.currentUser = user;
                this.borrowsCounter++;
                user.addBorrowedBook();
            }
            throw new BookAlreadyBorrowedException(getBookDetails().getTitle());
        }
        throw new TooManyBorrowsException(user.getName());

    }

    BookDetails processReturn() {
        currentUser.removeBorrowedBook();
        currentUser = null;
        if (borrowsCounter == Library.BOOK_WEAR) {
            return bookDetails.copy();
        }
        return null;
    }
}
