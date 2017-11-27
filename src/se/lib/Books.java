package se.lib;

import java.util.ArrayList;

class Books {
    private ArrayList<Book> bookList = new ArrayList<>();

    BookDetails returnBook(String bookname) {
        Book book = getBookByName(bookname);
        BookDetails bookWeared = book.returning();

        if (bookWeared != null) bookList.remove(book);
        return bookWeared;
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
