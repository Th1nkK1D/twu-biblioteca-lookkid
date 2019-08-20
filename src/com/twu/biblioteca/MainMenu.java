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
        switch (option) {
            case 0:
                return "Exit";
            case 1:
                return library.getListOfBooksName();
            default:
                return "Please select a valid option!";
        }
    }
}
