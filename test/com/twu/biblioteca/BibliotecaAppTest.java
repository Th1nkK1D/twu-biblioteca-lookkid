package com.twu.biblioteca;

import com.twu.biblioteca.items.Book;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BibliotecaAppTest {
    private ArrayList<Book> listOfBooks = new ArrayList<Book>();

    @Test
    public void welcomeMessageShouldBeShownWhenAppStart() {
        String message = BibliotecaApp.getWelcomeMessage();

        assertThat(message, is("Welcome to Biblioteca. Your one-stop-shop for great book titles on Bangalore!"));
    }
}