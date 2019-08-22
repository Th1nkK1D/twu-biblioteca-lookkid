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
        return bookCollection.checkoutItem(bookName, this.loggedInUser) ? "Thank you! Enjoy the book" : "Sorry, that book is not available";
    }

    public String returnBook(String bookName) {
        return bookCollection.returnItem(bookName) ? "Thank you for returning the book" : "That is not a valid book to return";
    }

    public String getListOfMoviesName() {
        String header = "";

        return this.movieCollection.printListOfAllItems(header, new MovieToStringWithName());
    }

    public String checkoutMovie(String movieName) {
        return movieCollection.checkoutItem(movieName, this.loggedInUser) ? "Thank you! Enjoy the movie" : "Sorry, that movie is not available";
    }

    public String returnMovie(String movieName) {
        return movieCollection.returnItem(movieName) ? "Thank you for returning the movie" : "That is not a valid movie to return";
    }

    public void login(String user, String pass) {
        if(this.accountManager.authenticate(user, pass)) {
            this.loggedInUser = user;
        }
    }

    public String getLoggedInUser() {
        return this.loggedInUser;
    }
}
