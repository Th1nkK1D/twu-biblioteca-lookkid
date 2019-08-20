package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LibraryTest {
    private ArrayList<Book> listOfBooks = new ArrayList<Book>();

    @Before
    public void setUp() {
        this.listOfBooks.add(new Book("Java Basic", "Steve", 2008));
        this.listOfBooks.add(new Book("How to TDD", "James", 2012));
    }

    @Test
    public void libraryShouldBeAbleToProvideListOfAllBooks() {
        Library library = new Library(this.listOfBooks);

        assertThat(library.getListOfBooksName(), is("Java Basic\nHow to TDD\n"));
    }

    @Test
    public void libraryShouldBeAbleToGiveAListOfAllBooksWithNameAuthorAndYear() {
        Library library = new Library(this.listOfBooks);

        String expectedOutput =
            "| name                     | author              | Year Published  |\n" +
            "| -------------------------|---------------------|-----------------|\n" +
            "| Java Basic               | Steve               | 2008            |\n" +
            "| How to TDD               | James               | 2012            |\n";

        assertThat(library.getListOfAllBooksWithNameAuthorAndYear(), is(expectedOutput));
    }

    @Test
    public void checkedOutBookShouldNotAppearOnListOfAllBooks() {
        Library library = new Library(this.listOfBooks);

        library.checkoutBook("Java Basic");

        assertThat(library.getListOfBooksName(), is("How to TDD\n"));
    }

    @Test
    public void checkedOutBookShouldNotAppearOnListOfAllBooksWithNameAuthorAndYear() {
        Library library = new Library(this.listOfBooks);

        String expectedOutput =
                "| name                     | author              | Year Published  |\n" +
                "| -------------------------|---------------------|-----------------|\n" +
                "| How to TDD               | James               | 2012            |\n";

        library.checkoutBook("Java Basic");

        assertThat(library.getListOfAllBooksWithNameAuthorAndYear(), is(expectedOutput));
    }

    @Test
    public void shouldGetSuccessMessageOnSuccessCheckout() {
        Library library = new Library(this.listOfBooks);

        String message = library.checkoutBook("Java Basic");

        assertThat(message, is("Thank you! Enjoy the book"));
    }

    @Test
    public void shouldGetUnsuccessfulUnsuccessfulCheckout() {
        Library library = new Library(this.listOfBooks);
        library.checkoutBook("Java Basic");

        String message = library.checkoutBook("Java Basic");

        assertThat(message, is("Sorry, that book is not available"));
    }
}