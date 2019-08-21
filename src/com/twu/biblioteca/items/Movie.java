package com.twu.biblioteca.items;

public class Movie implements Item {
    private String name;
    private int year;
    private String director;
    private int rating;
    private boolean isAvailable;

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.isAvailable = true;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public int getRating() {
        return rating;
    }

    public boolean getAvailability() {
        return isAvailable;
    }

    public boolean checkoutItem() {
        if(!this.isAvailable) {
            return false;
        }

        this.isAvailable = false;
        return true;
    }

    public boolean returnItem() {
        if(this.isAvailable) {
            return false;
        }

        this.isAvailable = true;
        return true;
    }
}
