package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BibliotecaAppTest {
    private ArrayList<Book> listOfBooks = new ArrayList<Book>();
    private BibliotecaApp app;

    @Before
    public void setUp() {
        this.listOfBooks.add(new Book("Java Basic"));
        this.listOfBooks.add(new Book("How to TDD"));

        app  = new BibliotecaApp(this.listOfBooks);
    }

    @Test
    public void welcomeMessageShouldBeShownWhenAppStart() {
        String message = BibliotecaApp.getWelcomeMessage();

        assertThat(message, is("Welcome to Biblioteca. Your one-stop-shop for great book titles on Bangalore!"));
    }

    @Test
    public void appShouldBeAbleToProvideListOfAllBooks() {
        assertThat(app.getListOfBooks(), is(this.listOfBooks));
    }
}