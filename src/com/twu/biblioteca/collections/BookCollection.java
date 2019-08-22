package com.twu.biblioteca.collections;

import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.parser.BookToStringParser;

import java.util.ArrayList;

public class BookCollection implements Collection {
    private ArrayList<Book> listOfBooks;

    public BookCollection(ArrayList<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public String printListOfAllItems(String header, BookToStringParser parser) {
        String listOfAllBook = header;

        for (Book book : this.listOfBooks) {
            if (book.getAvailability()) {
                listOfAllBook += parser.parse(book);
            }
        }

        return listOfAllBook;
    }

    public boolean checkoutItem(String bookName) {
        for(Book book : this.listOfBooks) {
            if (bookName == book.getName()) {
                return book.checkoutItem("");
            }
        }

        return false;
    }

    public boolean returnItem(String bookName) {
        for(Book book : this.listOfBooks) {
            if (bookName == book.getName()) {
                return book.returnItem();
            }
        }

        return false;
    }
}
