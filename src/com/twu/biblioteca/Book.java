package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private int year;
    private boolean isCheckout;

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.isCheckout = false;
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
        if(this.getCheckoutStatus()) {
            return false;
        }

        this.isCheckout = true;
        return true;
    }

    public boolean getCheckoutStatus() {
        return isCheckout;
    }
}
