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

    public void checkout() {
        this.isCheckout = true;
    }

    public boolean getCheckoutStatus() {
        return isCheckout;
    }
}
