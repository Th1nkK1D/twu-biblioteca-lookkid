package com.twu.biblioteca.parser;

import com.twu.biblioteca.items.Book;

public interface ItemToStringParser {
    String parse(Book book);
}
