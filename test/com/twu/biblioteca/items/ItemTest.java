package com.twu.biblioteca.items;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ItemTest {
    private Item item = new Item("apple");

    @Test
    public void shouldBeAbleToCheckoutItem() {
        assertThat(item.checkoutItem("John"), is(true));
    }

    @Test
    public void shouldBeAbleToCheckWhoCheckoutItem() {
        item.checkoutItem("John");

        assertThat(item.getBorrower(), is("John"));
    }

    @Test
    public void borrowerShouldBeAbleToReturnTheItem() {
        item.checkoutItem("John");
        assertThat(item.returnItem(), is(true));
    }
}