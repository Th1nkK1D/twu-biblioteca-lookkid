package com.twu.biblioteca;

import com.twu.biblioteca.collections.BookCollection;
import com.twu.biblioteca.collections.MovieCollection;
import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.items.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LibraryTest {
    private Library library;

    @Before
    public void setUp() {
        TreeMap<String, Account> accounts = new TreeMap<>();
        accounts.put("123-4567", new Account("123-4567","John", "password", "test@mail.com", "0862389627"));

        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("Java Basic", "Steve", 2008));
        listOfBooks.add(new Book("How to TDD", "James", 2012));

        ArrayList<Movie> listOfMovies = new ArrayList<>();
        listOfMovies.add(new Movie("The Avenger", 2011, "Someone", 4));
        listOfMovies.add(new Movie("The Iron Man", 2001, "Another one", 3));

        this.library = new Library(new AccountManager(accounts), new BookCollection(listOfBooks), new MovieCollection(listOfMovies));
    }

    @Test
    public void libraryShouldBeAbleToProvideListOfAllBooks() {
        assertThat(this.library.getListOfBooksName(), is("Java Basic\nHow to TDD\n"));
    }

    @Test
    public void libraryShouldBeAbleToGiveAListOfAllBooksWithNameAuthorAndYear() {
        String expectedOutput =
            "| name                     | author              | Year Published  |\n" +
            "| -------------------------|---------------------|-----------------|\n" +
            "| Java Basic               | Steve               | 2008            |\n" +
            "| How to TDD               | James               | 2012            |\n";

        assertThat(this.library.getListOfAllBooksWithNameAuthorAndYear(), is(expectedOutput));
    }

    @Test
    public void checkedOutBookShouldNotAppearOnListOfAllBooks() {
        this.library.login("123-4567", "password");
        this.library.checkoutBook("Java Basic");

        assertThat(this.library.getListOfBooksName(), is("How to TDD\n"));
    }

    @Test
    public void checkedOutBookShouldNotAppearOnListOfAllBooksWithNameAuthorAndYear() {
        String expectedOutput =
                "| name                     | author              | Year Published  |\n" +
                "| -------------------------|---------------------|-----------------|\n" +
                "| How to TDD               | James               | 2012            |\n";

        this.library.login("123-4567", "password");
        this.library.checkoutBook("Java Basic");

        assertThat(this.library.getListOfAllBooksWithNameAuthorAndYear(), is(expectedOutput));
    }

    @Test
    public void shouldGetSuccessMessageOnSuccessCheckout() {
        this.library.login("123-4567", "password");
        String message = this.library.checkoutBook("Java Basic");

        assertThat(message, is("Thank you! Enjoy the book"));
    }

    @Test
    public void shouldGetUnsuccessfulUnsuccessfulCheckout() {
        this.library.login("123-4567", "password");
        this.library.checkoutBook("Java Basic");

        String message = this.library.checkoutBook("Java Basic");

        assertThat(message, is("Sorry, that book is not available"));
    }

    @Test
    public void returnedBookShouldAppearOnListOfAllBooks() {
        this.library.login("123-4567", "password");
        this.library.checkoutBook("Java Basic");
        this.library.returnBook("Java Basic");

        assertThat(this.library.getListOfBooksName(), is("Java Basic\nHow to TDD\n"));
    }

    @Test
    public void returnedBookShouldAppearOnListOfAllBooksWithNameAuthorAndYear() {
        String expectedOutput =
                "| name                     | author              | Year Published  |\n" +
                "| -------------------------|---------------------|-----------------|\n" +
                "| Java Basic               | Steve               | 2008            |\n" +
                "| How to TDD               | James               | 2012            |\n";

        this.library.login("123-4567", "password");
        this.library.checkoutBook("Java Basic");

        this.library.returnBook("Java Basic");

        assertThat(this.library.getListOfAllBooksWithNameAuthorAndYear(), is(expectedOutput));
    }

    @Test
    public void shouldGetSuccessMessageOnSuccessfulReturn() {
        this.library.login("123-4567", "password");
        this.library.checkoutBook("Java Basic");

        String message = this.library.returnBook("Java Basic");

        assertThat(message, is("Thank you for returning the book"));
    }

    @Test
    public void shouldGetUnsuccessfulMessageOnUnsuccessfulReturn() {
        String message = this.library.returnBook("C Advance");

        assertThat(message, is("That is not a valid book to return"));
    }

    @Test
    public void libraryShouldBeAbleToProvideListOfAllMovies() {
        assertThat(this.library.getListOfMoviesName(), is("The Avenger\nThe Iron Man\n"));
    }

    @Test
    public void checkedOutMovieShouldNotAppearOnListOfAllMovies() {
        this.library.login("123-4567", "password");
        this.library.checkoutMovie("The Iron Man");

        assertThat(this.library.getListOfMoviesName(), is("The Avenger\n"));
    }

    @Test
    public void returnedMovieShouldAppearOnListOfAllMovies() {
        this.library.checkoutMovie("The Iron Man");
        this.library.returnMovie("The Iron Man");

        assertThat(this.library.getListOfMoviesName(), is("The Avenger\nThe Iron Man\n"));
    }

    @Test
    public void userShouldBeAbleToLogin() {
        this.library.login("123-4567", "password");

        assertThat(this.library.getLoggedInUser(), is("123-4567"));
    }

    @Test
    public void shouldGetUnsuccessfulMessageForCheckoutBookWithoutLoggedIn() {
        String message = this.library.checkoutBook("Java Basic");

        assertThat(message, is("Please log in first"));
    }

    @Test
    public void shouldGetUnsuccessfulMessageForCheckoutMovieWithoutLoggedIn() {
        String message = this.library.checkoutMovie("The Avenger");

        assertThat(message, is("Please log in first"));
    }
}