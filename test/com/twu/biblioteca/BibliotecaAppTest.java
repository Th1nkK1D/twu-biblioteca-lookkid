package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BibliotecaAppTest {

    @Test
    public void welcomeMessageShouldBeShownWhenAppStart() {
        BibliotecaApp app = new BibliotecaApp();

        String message = app.getWelcomeMessage();

        assertThat(message, is("Welcome to Biblioteca. Your one-stop-shop for great book titles on Bangalore!"));
    }
}