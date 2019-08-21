package com.twu.biblioteca;

import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.items.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LibraryTest {
    private ArrayList<Book> listOfBooks = new ArrayList<>();
    private ArrayList<Movie> listOfMovies = new ArrayList<>();
    private Library library;

    @Before
    public void setUp() {
        this.listOfBooks.add(new Book("Java Basic", "Steve", 2008));
        this.listOfBooks.add(new Book("How to TDD", "James", 2012));

        this.listOfMovies.add(new Movie("The Avenger", 2011, "Someone", 4));
        this.listOfMovies.add(new Movie("The Iron Man", 2001, "Another one", 3));

        this.library = new Library(this.listOfBooks, this.listOfMovies);
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
        this.library.checkoutBook("Java Basic");

        assertThat(this.library.getListOfBooksName(), is("How to TDD\n"));
    }

    @Test
    public void checkedOutBookShouldNotAppearOnListOfAllBooksWithNameAuthorAndYear() {
        String expectedOutput =
                "| name                     | author              | Year Published  |\n" +
                "| -------------------------|---------------------|-----------------|\n" +
                "| How to TDD               | James               | 2012            |\n";

        this.library.checkoutBook("Java Basic");

        assertThat(this.library.getListOfAllBooksWithNameAuthorAndYear(), is(expectedOutput));
    }

    @Test
    public void shouldGetSuccessMessageOnSuccessCheckout() {
        String message = this.library.checkoutBook("Java Basic");

        assertThat(message, is("Thank you! Enjoy the book"));
    }

    @Test
    public void shouldGetUnsuccessfulUnsuccessfulCheckout() {
        this.library.checkoutBook("Java Basic");

        String message = this.library.checkoutBook("Java Basic");

        assertThat(message, is("Sorry, that book is not available"));
    }

    @Test
    public void returnedBookShouldAppearOnListOfAllBooks() {
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

        this.library.checkoutBook("Java Basic");

        this.library.returnBook("Java Basic");

        assertThat(this.library.getListOfAllBooksWithNameAuthorAndYear(), is(expectedOutput));
    }

    @Test
    public void shouldGetSuccessMessageOnSuccessfulReturn() {
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
}