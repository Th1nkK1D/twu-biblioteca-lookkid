package com.twu.biblioteca.collections;

import com.twu.biblioteca.items.Movie;
import com.twu.biblioteca.parser.MovieToStringParser;

import java.util.ArrayList;

public class MovieCollection {
    private ArrayList<Movie> listOfMovies;

    public MovieCollection(ArrayList<Movie> listOfMovies) {
        this.listOfMovies = listOfMovies;
    }

    public String printListOfAllItems(String header, MovieToStringParser parser) {
        String listOfAllMovie = header;

        for (Movie movie : this.listOfMovies) {
            if (movie.getAvailability()) {
                listOfAllMovie += parser.parse(movie);
            }
        }

        return listOfAllMovie;
    }

    public boolean checkoutItem(String movieName) {
        for(Movie movie : this.listOfMovies) {
            if (movieName == movie.getName()) {
                return movie.checkoutItem("");
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
}
