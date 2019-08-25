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

public class MainMenuTest {
    private MainMenu mainMenu;

    @Before
    public void setUp() throws Exception {
        TreeMap<String, Account> accounts = new TreeMap<>();
        accounts.put("123-4567", new Account("123-4567","John", "password", "test@mail.com", "0862389627"));

        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("Java Basic", "Steve", 2008));
        listOfBooks.add(new Book("How to TDD", "James", 2012));

        ArrayList<Movie> listOfMovies = new ArrayList<>();
        listOfMovies.add(new Movie("The Avenger", 2011, "Someone", 4));
        listOfMovies.add(new Movie("The Iron Man", 2001, "Another one", 3));

        Library library = new Library(new AccountManager(accounts), new BookCollection(listOfBooks), new MovieCollection(listOfMovies));

        mainMenu = new MainMenu("1 - List of Books\n0 - Quit", library);
    }

    @Test
    public void shouldBeAbleToGetListOfOptionsFromMainMenu() {
        String listOfOptions = mainMenu.getListOfOptions();

        assertThat(listOfOptions, is("1 - List of Books\n0 - Quit"));
    }

    @Test
    public void shouldBeAbleToGetListOfBookWhenSelectOption1() {
        String output = mainMenu.selectOption(1);

        assertThat(output, is("Java Basic\nHow to TDD\n"));
    }


    @Test
    public void shouldGetNotifyWhenSelectOption2() {
        String output = mainMenu.selectOption(2);

        assertThat(output, is("Please select a valid option!"));
    }

    @Test
    public void shouldGetExitFlagWhenSelectOption0() {
        String output = mainMenu.selectOption(0);

        assertThat(output, is("Exit"));
    }
}