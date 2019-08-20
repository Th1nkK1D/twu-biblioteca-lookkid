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
        return "";
    }
}
