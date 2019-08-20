package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MainMenuTest {
    private MainMenu mainMenu;

    @Before
    public void setUp() throws Exception {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book("Java Basic", "Steve", 2008));

        mainMenu = new MainMenu("1 - List of Books", new Library(listOfBooks));
    }

    @Test
    public void shouldBeAbleToGetListOfOptionsFromMainMenu() {
        String listOfOptions = mainMenu.getListOfOptions();

        assertThat(listOfOptions, is("1 - List of Books"));
    }

    @Test
    public void shouldBeAbleToGetListOfBookWhenSelectOption1() {
        String output = mainMenu.selectOption(1);

        assertThat(output, is("Java Basic\n"));
    }
}