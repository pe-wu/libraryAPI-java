package se.lib;
 class Book {
    private BookDetails details;
    private int borrowsIndex;
    private User currentBorrower;

    Book(BookDetails bookDetails) {
        this.details = bookDetails;
        this.borrowsIndex = 0;
    }

    private int getBorrowsIndex() {
        return borrowsIndex;
    }

    private User getCurrentBorrower() {
        return currentBorrower;
    }
    
    @Override
    public String toString() {
       	return details.toString();
    }
}
