package com.twu.biblioteca.collections;

import com.twu.biblioteca.items.Movie;
import com.twu.biblioteca.parser.MovieToStringParser;
import com.twu.biblioteca.parser.MovieToStringWithName;

import java.util.ArrayList;

public class MovieCollection {
    private ArrayList<Movie> listOfMovies;

    public MovieCollection(ArrayList<Movie> listOfMovies) {
        this.listOfMovies = listOfMovies;
    }

    public boolean checkoutItem(String movieName, String borrower) {
        for(Movie movie : this.listOfMovies) {
            if (movieName == movie.getName()) {
                return movie.checkoutItem(borrower);
            }
        }

        return false;
    }

    public boolean returnItem(String movieName) {
        for(Movie movie : this.listOfMovies) {
            if (movieName == movie.getName()) {
                return movie.returnItem();
            }
        }

        return false;
    }

    public String getListOfAvailableItems() {
        String header = "";

        return this.printListOfAllItems(header, new MovieToStringWithName());
    }

    public String getListOfAvailableItemsWithDetails() {
        return "";
    }

    private String printListOfAllItems(String header, MovieToStringParser parser) {
        String listOfAllMovie = header;

        for (Movie movie : this.listOfMovies) {
            if (movie.getAvailability()) {
                listOfAllMovie += parser.parse(movie);
            }
        }

        return listOfAllMovie;
    }
}
