package se.libclient;

import se.lib.*;

import java.util.Scanner;

public class ClientExample {
    private static Library lib;
    private static Scanner scanner;

    public static void main(String[] args) {
        lib = new Library();

        showWelcome();
        String command = scanner.nextLine();

        while (!command.equals("e")) {
            executeCommand(command);
            System.out.print(">");
            command = scanner.nextLine();
        }
    }

    private static void showWelcome() {
        System.out.println("What's your name?");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hi " + name + "! Type h to get list of possible options");
        System.out.print(">");
    }

    private static void executeCommand(String command) {
        switch (command) {

            case "h":
                cShowHelp();
                break;

            case "books":
                cShowBooks();
                break;
            case "borrow":
                cBorrow();
                break;
            case "r":
                cAddRequest();
                break;
            case "rr":
                cAddRequests();
                break;
            case "u":
                cAddUser();
                break;
            case "uu":
                cAddUsers();
                break;
            default:
                System.out.println("unsupported operation!");
        }
    }

    private static void cBorrow() {
        System.out.print("User id: ");
        String user = scanner.nextLine();
        System.out.print("Book's title: ");
        String title = scanner.nextLine();
        try {
            lib.bookBorrow(user, title);
        } catch (UserNotFoundException | BookNotFoundException | BookAlreadyBorrowedException |
                TooManyBorrowsException e) {
            e.printStackTrace();
        }
    }

    private static void cShowBooks() {
        System.out.println(lib.getBooks());
    }

    private static void cShowHelp() {
        System.out.println("h - show help");
        System.out.println("e - exit");
        System.out.println("");
        System.out.println("books - show books");
        System.out.println("borrow - borrow a book");
        System.out.println("r - add bookRequest");
        System.out.println("rr - add bookRequests fast");
        System.out.println("u - add user");
        System.out.println("uu - add users fast");
    }

    private static void cAddRequest() {
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();

        lib.newRequest(isbn, author, title);
    }

    private static void cAddUser() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        lib.addUser(username);
    }

    private static void cAddUsers() {
        lib.addUser("Adina");
        lib.addUser("Alexey");
        lib.addUser("Narek");
        lib.addUser("Piotrek");
    }

    private static void cAddRequests() {
        System.out.print("How many books: ");
        int howManyBooks = Integer.parseInt(scanner.nextLine());

        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();

        for (int i = 0; i < howManyBooks; i++) {
            lib.newRequest(isbn + i, author, title);
        }

        System.out.println(howManyBooks + " requests executed!");
    }

    private static void cGetRequestCurrentIndex() {
        System.out.print("Book title: ");
        String title = scanner.nextLine();

        try {
            System.out.println(lib.getBookRequestsCounter(title));
        } catch (RequestNotFoundException e) {
            e.printStackTrace();
        }
    }

}
