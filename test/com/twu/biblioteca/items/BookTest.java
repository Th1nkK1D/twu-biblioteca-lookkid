package com.twu.biblioteca.items;

import com.twu.biblioteca.items.Book;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BookTest {
    private Book book;

    @Before
    public void setUp() throws Exception {
        this.book = new Book("Java Basic", "Steve", 2008);
    }

    @Test
    public void shouldBeAbleToGetNameFromBook() {
        String bookName = this.book.getName();

        assertThat(bookName, is("Java Basic"));
    }

    @Test
    public void shouldBeAbleToGetAuthorFromBook() {
        String bookAuthor = this.book.getAuthor();

        assertThat(bookAuthor, is("Steve"));
    }

    @Test
    public void shouldBeAbleToGetYearFromBook() {
        int bookYear = this.book.getYear();

        assertThat(bookYear, is(2008));
    }

    @Test
    public void shouldBeAbleToCheckout() {
        this.book.checkoutItem("John");

        assertThat(this.book.getAvailability(), is(false));
    }

    @Test
    public void shouldGetFalseWhenCheckoutTheBookThatAlreadyCheckedOut() {
        this.book.checkoutItem("John");

        boolean result = this.book.checkoutItem("John");

        assertThat(result, is(false));
    }

    @Test
    public void shouldBeAbleToReturn() {
        this.book.checkoutItem("John");

        this.book.returnItem();

        assertThat(this.book.getAvailability(), is(true));
    }

    @Test
    public void shouldGetTrueWhenTheBookIsReturned() {
        this.book.checkoutItem("John");

        boolean result = this.book.returnItem();

        assertThat(result, is(true));
    }

    @Test
    public void shouldGetFalseWhenReturnTheBookThatIsNotCheckedOut() {
        boolean result = this.book.returnItem();

        assertThat(result, is(false));
    }

}