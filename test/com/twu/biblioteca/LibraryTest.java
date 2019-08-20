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
        this.listOfBooks.add(new Book("Java Basic"));
        this.listOfBooks.add(new Book("How to TDD"));

        this.library  = new Library(this.listOfBooks);
    }

    @Test
    public void libraryShouldBeAbleToProvideListOfAllBooks() {
        assertThat(library.getListOfBooks(), is(this.listOfBooks));
    }
}