package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> listOfBooks;

    public Library(ArrayList<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public String getListOfBooksName() {
        String listOfBooksName = "";

        for (Book book : this.listOfBooks) {
            if (book.getAvailability()) {
                listOfBooksName += String.format("%s\n", book.getName());
            }
        }

        return listOfBooksName;
    }

    public String getListOfAllBooksWithNameAuthorAndYear() {
        String listOfAllBooksWithNameAuthorAndYear =
                "| name                     | author              | Year Published  |\n" +
                "| -------------------------|---------------------|-----------------|\n";

        for (Book book : this.listOfBooks) {
            if (book.getAvailability()) {
                listOfAllBooksWithNameAuthorAndYear +=
                        String.format("| %-24s | %-19s | %-15s |\n", book.getName(), book.getAuthor(), book.getYear());
            }
        }

        return listOfAllBooksWithNameAuthorAndYear;
    }

    public String checkoutBook(String bookName) {
        for(Book book : this.listOfBooks) {
            if (bookName == book.getName()) {
                return book.checkout() ? "Thank you! Enjoy the book" : "Sorry, that book is not available";
            }
        }

        return "Sorry, that book is not available";
    }

    public void returnBook(String bookName) {
        for(Book book : this.listOfBooks) {
            if (bookName == book.getName()) {
                book.returnBook();
                break;
            }
        }
    }
}
