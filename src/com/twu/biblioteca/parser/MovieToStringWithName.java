package com.twu.biblioteca.parser;

import com.twu.biblioteca.items.Movie;

public class MovieToStringWithName implements MovieToStringParser {
    public String parse (Movie movie) {
        return String.format("%s\n", movie.getName());
    }
}
