package com.twu.biblioteca;

import com.twu.biblioteca.collections.BookCollection;
import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.parser.BookToStringWithName;
import com.twu.biblioteca.parser.BookToStringWithNameAuthorYear;

import java.util.ArrayList;

public class Library {
    private BookCollection bookCollection;

    public Library(ArrayList<Book> listOfBooks) {
        this.bookCollection = new BookCollection(listOfBooks);
    }

    public String getListOfBooksName() {
        String header = "";

        return this.bookCollection.printListOfAllItems(header, new BookToStringWithName());

    }

    public String getListOfAllBooksWithNameAuthorAndYear() {
        String header =
                "| name                     | author              | Year Published  |\n" +
                "| -------------------------|---------------------|-----------------|\n";

        return this.bookCollection.printListOfAllItems(header, new BookToStringWithNameAuthorYear());
    }

    public String checkoutBook(String bookName) {
        return bookCollection.checkoutItem(bookName) ? "Thank you! Enjoy the book" : "Sorry, that book is not available";
    }

    public String returnBook(String bookName) {
        return bookCollection.returnItem(bookName) ? "Thank you for returning the book" : "That is not a valid book to return";
    }
}
