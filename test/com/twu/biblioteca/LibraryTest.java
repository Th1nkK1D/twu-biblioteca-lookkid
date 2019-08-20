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

        this.library  = new Library(this.listOfBooks);
    }

    @Test
    public void libraryShouldBeAbleToProvideListOfAllBooks() {
        assertThat(library.getListOfBooks(), is(this.listOfBooks));
    }

    @Test
    public void libraryShouldBeAbleToGiveAListOfAllBooksWithNameAuthorAndYear() {
        String expectedOutput =
            "| name                     | author              | Year Published  |\n" +
            "| -------------------------|---------------------|-----------------|\n" +
            "| Java Basic               | Steve               | 2008            |\n" +
            "| How to TDD               | James               | 2012            |\n";

        assertThat(library.getListOfAllBooksWithNameAuthorAndYear(), is(expectedOutput));
    }
}