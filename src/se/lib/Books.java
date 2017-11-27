package se.lib;

import java.util.ArrayList;

class Books {
    private ArrayList<Book> bookList = new ArrayList<>();

    BookDetails returnBook(String bookname) {
        Book book = getBookByName(bookname);
        book.getCurrentUser().removeBorrowedBook(book);
        book.removeUser();
        if (book.getBorrowsIndex() < Library.BOOK_WEAR) return null;
        else {
            BookDetails bookToRequest = book.getBookDetails().copy(); //clone() not implemented intentionally;
            bookList.remove(book);
            return bookToRequest;
        }
    }

    String getBookList() {
        StringBuilder booksInLibrary = new StringBuilder("");
            for (Book b : bookList) {
                booksInLibrary.append(b.getBookDetails().toString());
                booksInLibrary.append("\n");
            }
        return booksInLibrary.toString();
    }

    void buyBook(BookDetails bookDetails) {
        bookList.add(new Book(bookDetails));
    }

    Book getBookByName(String bookname) {
        for (Book book : bookList) {
            if (book.getBookDetails().getTitle().equals(bookname)) {
                return book;
            }
        }
        return null;
        //TODO BookNotFoundException
    }

}
