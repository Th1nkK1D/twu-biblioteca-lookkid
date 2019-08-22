package com.twu.biblioteca.items;

import com.twu.biblioteca.items.Movie;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieTest {
    private Movie movie;

    @Before
    public void setUp() throws Exception {
        this.movie = new Movie("The Avenger", 2001, "Someone", 4);
    }

    @Test
    public void shouldBeAbleToGetNameFromMovie() {
        assertThat(this.movie.getName(), is("The Avenger"));
    }

    @Test
    public void shouldBeAbleToGetYearFromMovie() {
        assertThat(this.movie.getYear(), is(2001));
    }

    @Test
    public void shouldBeAbleToGetDirectorFromMovie() {
        assertThat(this.movie.getDirector(), is("Someone"));
    }

    @Test
    public void shouldBeAbleToGetRatingFromMovie() {
        assertThat(this.movie.getRating(), is(4));
    }

    @Test
    public void shouldBeAbleToCheckout() {
        this.movie.checkoutItem("John");

        assertThat(this.movie.getAvailability(), is(false));
    }

    @Test
    public void shouldGetFalseWhenCheckoutTheMovieThatAlreadyCheckedOut() {
        this.movie.checkoutItem("John");

        boolean result = this.movie.checkoutItem("John");

        assertThat(result, is(false));
    }

    @Test
    public void shouldBeAbleToReturn() {
        this.movie.checkoutItem("John");

        this.movie.returnItem();

        assertThat(this.movie.getAvailability(), is(true));
    }

    @Test
    public void shouldGetTrueWhenTheMovieIsReturned() {
        this.movie.checkoutItem("John");

        boolean result = this.movie.returnItem();

        assertThat(result, is(true));
    }

    @Test
    public void shouldGetFalseWhenReturnTheMovieThatIsNotCheckedOut() {
        boolean result = this.movie.returnItem();

        assertThat(result, is(false));
    }

}