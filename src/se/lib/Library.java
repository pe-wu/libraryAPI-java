package se.lib;

/**
 * Library API main class.
 * Can be instantiated with an default constructor without additional parameters.
 */
public class Library {

    /**
     * defines after how many borrows a book is removed from the library.
     */
    static final int BOOK_WEAR = 50;

    /**
     * defines how many simultaneous borrows a library's user is able to make.
     */
    static final int BORROWS_PER_USER = 10;

    /**
     * defines how many requests need to be submitted,
     * if the book was never before in the library,
     * in order to result in a first book's buy.
     */
    static final int DEFAULT_REQUESTS = 5;

    /**
     * defines how many requests need to be submitted,
     * if the book was already in the library,
     * in order to result in a next book's buy.
     */
    static final int RENEWAL_REQUESTS = 2;

    private Users users = new Users();
    private Books books = new Books();
    private Requests requests = new Requests();

    /**
     * Default public constructor. Takes no arguments.
     */
    public Library() {
    }

    /**
     * provides registration of new users in the API.
     *
     * @param username of a newly registered user.
     */
    public void addUser(String username) {
        users.add(username);
    }

    /**
     * issues new book buy-request by users.
     *
     * @param title  unique title of the requested book.
     * @param author of the requested book.
     * @param isbn   unique ISBN nummer of the requested book.
     */
    public void newRequest(String title, String author, String isbn) {
        BookDetails userRequestDetails = new BookDetails(isbn, author, title);

        BookDetails bookToBuy = requests.addUserRequest(userRequestDetails);
        if (bookToBuy != null) books.buyBook(bookToBuy);
    }

    /**
     * provides borrowing books by users.
     *
     * @param username of the borrower.
     * @param title    of the book the borrower would like to borrow.
     * @throws BookAlreadyBorrowedException if the book is already borrowed by other user.
     * @throws BookNotFoundException        if there is no book of a given title in Library.
     * @throws TooManyBorrowsException      if the user has already reached borrows limit.
     * @throws UserNotFoundException        if there is no user of a given name in Library.
     */
    public void bookBorrow(String username, String title) throws BookAlreadyBorrowedException, BookNotFoundException, TooManyBorrowsException, UserNotFoundException {
        User user = users.getUserByName(username);
        Book book = books.getBookByTitle(title);
        book.borrowing(user);
    }

    /**
     * provides returning books by users.
     *
     * @param title of the book being returned.
     * @throws BookNotFoundException if there is no book of a given title in Library.
     */
    public void bookReturn(String title) throws BookNotFoundException {
        Book book = books.getBookByTitle(title);

        BookDetails libRequestDetails = books.returnBook(book);
        if (libRequestDetails != null) requests.addLibraryRequest(libRequestDetails);
    }

    /**
     * lists all books bought by the library.
     *
     * @return contains books available to borrow or currently borrowed by library's users.
     */
    public String getBooks() {
        return books.getBookList();
    }

    /**
     * checks who is a current borrower of a given book.
     *
     * @param title of the book being borrowed.
     * @return name of a user.
     * @throws BookNotFoundException        if there is no book of a given title in Library.
     * @throws CurrentUserNotFoundException if no user is currently borrowing the book.
     */
    public String getBookCurrentUser(String title) throws BookNotFoundException, CurrentUserNotFoundException {
        return books.getBookByTitle(title).getCurrentUser().getName();
    }

    /**
     * checks how many times a book was borrowed.
     *
     * @param title of the book being checked.
     * @return borrows number.
     * @throws BookNotFoundException if there is no book of a given title in Library.
     */
    public int getBookBorrowsIndex(String title) throws BookNotFoundException {
        return books.getBookByTitle(title).getBorrowsIndex();
    }

    /**
     * checks how many times a book was borrowed.
     *
     * @param title of the requested book being checked.
     * @return requests number.
     * @throws RequestNotFoundException if there is no request of a given title in Library.
     */
    public int getRequestCurrentIndex(String title) throws RequestNotFoundException {
        return requests.getRequestByName(title).getRequestsIndex();
    }

}
