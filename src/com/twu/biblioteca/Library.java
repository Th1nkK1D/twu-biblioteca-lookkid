package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> listOfBooks;

    public Library(ArrayList<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public String getListOfBooksName() {
        String header = "";
        BookToStringParser BookNameParser = (Book book) -> String.format("%s\n", book.getName());

        return this.printListOfAllBooks(header, BookNameParser);
    }

    public String getListOfAllBooksWithNameAuthorAndYear() {
        String header =
                "| name                     | author              | Year Published  |\n" +
                "| -------------------------|---------------------|-----------------|\n";

        BookToStringParser BookNameParser = (Book book) -> String.format("| %-24s | %-19s | %-15s |\n", book.getName(), book.getAuthor(), book.getYear());

        return this.printListOfAllBooks(header, BookNameParser);
    }

    private interface BookToStringParser {
        public String parse(Book book);
    }

    private String printListOfAllBooks(String header, BookToStringParser parser) {
        String listOfAllBook = header;

        for (Book book : this.listOfBooks) {
            if (book.getAvailability()) {
                listOfAllBook += parser.parse(book);
            }
        }

        return listOfAllBook;
    }

    public String checkoutBook(String bookName) {
        for(Book book : this.listOfBooks) {
            if (bookName == book.getName()) {
                return book.checkout() ? "Thank you! Enjoy the book" : "Sorry, that book is not available";
            }
        }

        return "Sorry, that book is not available";
    }

    public String returnBook(String bookName) {
        for(Book book : this.listOfBooks) {
            if (bookName == book.getName()) {
                return book.returnBook() ? "Thank you for returning the book" : "That is not a valid book to return";
            }
        }

        return "That is not a valid book to return";
    }
}
