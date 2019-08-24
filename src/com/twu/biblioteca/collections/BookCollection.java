package com.twu.biblioteca.collections;

import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.parser.BookToStringParser;
import com.twu.biblioteca.parser.BookToStringWithName;
import com.twu.biblioteca.parser.BookToStringWithNameAuthorYear;

import java.util.ArrayList;

public class BookCollection implements Collection {
    private ArrayList<Book> listOfBooks;

    public BookCollection(ArrayList<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public boolean checkoutItem(String bookName, String borrower) {
        for(Book book : this.listOfBooks) {
            if (bookName == book.getName()) {
                return book.checkoutItem(borrower);
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

    public String getListOfAvailableItems() {
        return this.printListOfAllItems("", new BookToStringWithName());
    }

    public String getListOfAvailableItemsWithDetails() {
        String header = "| name                     | author              | Year Published  |\n" +
                "| -------------------------|---------------------|-----------------|\n";

        return this.printListOfAllItems(header, new BookToStringWithNameAuthorYear());
    }

    private String printListOfAllItems(String header, BookToStringParser parser) {
        String listOfAllBook = header;

        for (Book book : this.listOfBooks) {
            if (book.getAvailability()) {
                listOfAllBook += parser.parse(book);
            }
        }

        return listOfAllBook;
    }
}
