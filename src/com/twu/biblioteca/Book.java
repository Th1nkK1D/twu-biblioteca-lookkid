package com.twu.biblioteca;

public class Book {
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

    public boolean checkout() {
        if(!this.getAvailability()) {
            return false;
        }

        this.isAvailable = false;
        return true;
    }

    public boolean getAvailability() {
        return isAvailable;
    }

    public boolean returnBook() {
        if(this.getAvailability()) {
            return false;
        }

        this.isAvailable = true;
        return true;
    }
}
