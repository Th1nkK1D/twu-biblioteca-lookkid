package com.twu.biblioteca.items;

import com.twu.biblioteca.items.Item;

public class Book extends Item {
    private String name;
    private String author;
    private int year;
    private boolean isAvailable;

    public Book(String name, String author, int year) {
        super(name);
        this.author = author;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}
