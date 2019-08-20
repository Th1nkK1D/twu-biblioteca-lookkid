package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> listOfBooks;

    public Library(ArrayList<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public ArrayList<Book> getListOfBooks() {
        return listOfBooks;
    }

    public String getListOfAllBooksWithNameAuthorAndYear() {
        String listOfAllBooksWithNameAuthorAndYear =
                "| name                     | author              | Year Published  |\n" +
                "| -------------------------|---------------------|-----------------|\n";

        for (Book book : this.listOfBooks) {
            listOfAllBooksWithNameAuthorAndYear +=
                    String.format("| %-24s | %-19s | %-15s |\n", book.getName(), book.getAuthor(), book.getYear());
        }

        return listOfAllBooksWithNameAuthorAndYear;
    }
}
