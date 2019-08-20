package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MainMenuTest {
    private MainMenu mainMenu;

    @Before
    public void setUp() throws Exception {
        mainMenu = new MainMenu("1 - List of Books");
    }

    @Test
    public void shouldBeAbleToGetListOfOptionsFromMainMenu() {
        String listOfOptions = mainMenu.getListOfOptions();

        assertThat(listOfOptions, is("1 - List of Books"));
    }
}