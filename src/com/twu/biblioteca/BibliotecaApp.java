package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
    private ArrayList<Book> ListOfBooks;

    public static void main(String[] args) {
        System.out.println(BibliotecaApp.getWelcomeMessage());
    }

    public static String getWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles on Bangalore!";
    }

    public BibliotecaApp(ArrayList<Book> ListOfBooks) {
        this.ListOfBooks = ListOfBooks;
    }

    public ArrayList<Book> getListOfBooks() {
        return this.ListOfBooks;
    }
}
