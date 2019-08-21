package com.twu.biblioteca.items;

import com.twu.biblioteca.items.Item;

public class Book implements Item {
    private String name;
    private String author;
    private int year;
    private boolean isAvailable;

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.isAvailable = true;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean getAvailability() {
        return isAvailable;
    }

    public boolean checkoutItem() {
        if(!this.getAvailability()) {
            return false;
        }

        this.isAvailable = false;
        return true;
    }

    public boolean returnItem() {
        if(this.getAvailability()) {
            return false;
        }

        this.isAvailable = true;
        return true;
    }
}
