package com.twu.biblioteca.parser;

import com.twu.biblioteca.items.Book;

public class BookToStringWithNameAuthorYear implements BookToStringParser {
    public String parse (Book book) {
        return String.format("| %-24s | %-19s | %-15s |\n", book.getName(), book.getAuthor(), book.getYear());
    }
}
