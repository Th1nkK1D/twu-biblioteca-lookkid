package com.twu.biblioteca.parser;

import com.twu.biblioteca.items.Book;

public class BookToStringWithName implements ItemToStringParser {
    public String parse (Book book) {
        return String.format("%s\n", book.getName());
    }
}
