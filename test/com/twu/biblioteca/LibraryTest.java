package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LibraryTest {
    private ArrayList<Book> listOfBooks = new ArrayList<Book>();
    private Library library;

    @Before
    public void setUp() {
        this.listOfBooks.add(new Book("Java Basic", "Steve", 2008));
        this.listOfBooks.add(new Book("How to TDD", "James", 2012));

        this.library = new Library(this.listOfBooks);
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
}