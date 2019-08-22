package com.twu.biblioteca;

import com.twu.biblioteca.collections.AccountManager;
import com.twu.biblioteca.collections.BookCollection;
import com.twu.biblioteca.collections.MovieCollection;
import com.twu.biblioteca.parser.BookToStringWithName;
import com.twu.biblioteca.parser.BookToStringWithNameAuthorYear;
import com.twu.biblioteca.parser.MovieToStringWithName;

import java.util.ArrayList;

public class Library {
    private AccountManager accountManager;
    private BookCollection bookCollection;
    private MovieCollection movieCollection;
    private String loggedInUser;

    public Library(AccountManager accountManager, BookCollection bookCollection, MovieCollection movieCollection) {
        this.accountManager = accountManager;
        this.bookCollection = bookCollection;
        this.movieCollection = movieCollection;
        this.loggedInUser = "";
    }

    public String getListOfBooksName() {
        String header = "";

        return this.bookCollection.printListOfAllItems(header, new BookToStringWithName());

    }

    public String getListOfAllBooksWithNameAuthorAndYear() {
        String header =
                "| name                     | author              | Year Published  |\n" +
                "| -------------------------|---------------------|-----------------|\n";

        return this.bookCollection.printListOfAllItems(header, new BookToStringWithNameAuthorYear());
    }

    public String checkoutBook(String bookName) {
        return bookCollection.checkoutItem(bookName) ? "Thank you! Enjoy the book" : "Sorry, that book is not available";
    }

    public String returnBook(String bookName) {
        return bookCollection.returnItem(bookName) ? "Thank you for returning the book" : "That is not a valid book to return";
    }

    public String getListOfMoviesName() {
        String header = "";

        return this.movieCollection.printListOfAllItems(header, new MovieToStringWithName());
    }

    public boolean checkoutMovie(String movieName) {
        return movieCollection.checkoutItem(movieName);
    }

    public boolean returnMovie(String movieName) {
        return movieCollection.returnItem(movieName);
    }
}
