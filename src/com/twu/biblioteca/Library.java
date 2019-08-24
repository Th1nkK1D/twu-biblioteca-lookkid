package com.twu.biblioteca;

import com.twu.biblioteca.collections.AccountManager;
import com.twu.biblioteca.collections.BookCollection;
import com.twu.biblioteca.collections.MovieCollection;

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
        return this.bookCollection.getListOfAvailableItems();

    }

    public String getListOfAllBooksWithNameAuthorAndYear() {
        return this.bookCollection.getListOfAvailableItemsWithDetails();
    }

    public String checkoutBook(String bookName) {
        if (!this.isUserLoggedIn()) {
            return "Please log in first";
        }
        return bookCollection.checkoutItem(bookName, this.loggedInUser) ? "Thank you! Enjoy the book" : "Sorry, that book is not available";
    }

    public String returnBook(String bookName) {
        return bookCollection.returnItem(bookName) ? "Thank you for returning the book" : "That is not a valid book to return";
    }

    public String getListOfMoviesName() {
        String header = "";

        return this.movieCollection.getListOfAvailableItems();
    }

    public String checkoutMovie(String movieName) {
        if (!this.isUserLoggedIn()) {
            return "Please log in first";
        }
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

    private boolean isUserLoggedIn() {
        return this.getLoggedInUser().length() > 0;
    }
}
