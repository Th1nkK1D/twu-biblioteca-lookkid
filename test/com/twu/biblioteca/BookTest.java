package com.twu.biblioteca;

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
    public void ShouldBeAbleToCheckout() {
        this.book.checkout();

        assertThat(this.book.getCheckoutStatus(), is(true));
    }

    @Test
    public void ShouldGetFalseWhenCheckoutTheBookThatAlreadyCheckedOut() {
        this.book.checkout();

        boolean result = this.book.checkout();

        assertThat(result, is(false));
    }
}