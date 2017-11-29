package se.lib;

import java.util.ArrayList;

class Books {
    private final ArrayList<Book> bookList = new ArrayList<>();

    BookDetails returnBook(Book book) {
        BookDetails bookWeared = book.processReturn();
        if (bookWeared != null) {
            bookList.remove(book);
        }
        return bookWeared;
    }

    @Override
    public String toString() {
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

    Book findBookByTitle(String bookname) throws BookNotFoundException {
        for (Book book : bookList) {
            if (book.getBookDetails().getTitle().equals(bookname)) {
                return book;
            }
        }
        throw new BookNotFoundException(bookname);
    }

}
