package se.lib;

public class Library {
    static final int RENEWAL_REQUESTS = 2;
    static final int NORMAL_REQUESTS = 5;
    static final int BOOK_WEAR = 50;
    static final int BORROWS_PER_USER = 10;

    private Users users = new Users();
    private Books books = new Books();
    private Requests requests = new Requests();

    public void addUser(String username) {
        users.add(username);
    }

    public void addUserRequest(String isbn, String author, String title) {
        BookDetails userRequestDetails = new BookDetails(isbn, author, title);
        BookDetails bookToBuy = requests.addRequest(userRequestDetails);

        if (bookToBuy != null) books.buyBook(bookToBuy);
    }

    public void bookBorrow(String username, String bookname) {
        User user = users.getUserByName(username);
        Book book = books.getBookByName(bookname);
        book.borrowing(user);
    }

    public void bookReturn(String bookname) {
        BookDetails libRequestDetails = books.returnBook(bookname);

        if (libRequestDetails != null) requests.addLibraryRequest(libRequestDetails);
    }

    public String getBooks() {
        return books.getBookList();
    }

    public String getBookCurrentUser(String bookname) {
        return books.getBookByName(bookname).getCurrentUser().getName();
    }

    public int getBookBorrowsIndex(String bookname) {
        return books.getBookByName(bookname).getBorrowsIndex();
    }

    public int getRequestCurrentIndex(String bookname) {
        return requests.getRequestByName(bookname).getRequestsIndex();
    }

}
