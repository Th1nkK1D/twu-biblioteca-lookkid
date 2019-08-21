package com.twu.biblioteca.items;

public class Movie extends Item {
    private String name;
    private int year;
    private String director;
    private int rating;
    private boolean isAvailable;

    public Movie(String name, int year, String director, int rating) {
        super(name);

        this.year = year;
        this.director = director;
        this.rating = rating;
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
}
