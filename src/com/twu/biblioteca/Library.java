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
            if (!book.getCheckoutStatus()) {
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
            if (!book.getCheckoutStatus()) {
                listOfAllBooksWithNameAuthorAndYear +=
                        String.format("| %-24s | %-19s | %-15s |\n", book.getName(), book.getAuthor(), book.getYear());
            }
        }

        return listOfAllBooksWithNameAuthorAndYear;
    }

    public String checkoutBook(String bookName) {
        for(Book book : this.listOfBooks) {
            if (bookName == book.getName()) {
                return  book.checkout() ? "Thank you! Enjoy the book" : "";
            }
        }

        return "";
    }
}
