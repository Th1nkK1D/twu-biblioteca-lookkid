package com.twu.biblioteca;

public class MainMenu {
    private String listOfOptions;
    private Library library;

    public MainMenu(String listOfOptions, Library library) {
        this.listOfOptions = listOfOptions;
        this.library = library;
    }

    public String getListOfOptions() {
        return listOfOptions;
    }

    public String selectOption(int option) {
        return library.getListOfBooksName();
    }
}
