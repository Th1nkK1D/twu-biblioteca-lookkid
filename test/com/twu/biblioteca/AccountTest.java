package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AccountTest {
    private Account account = new Account("123-4567","John", "password", "test@mail.com", "0862389627");

    @Test
    public void shouldBeAbleToGetName() {
        assertThat(account.getName(), is("John"));
    }

    @Test
    public void shouldBeAbleToGetEmail() {
        assertThat(account.getEmail(), is("test@mail.com"));
    }

    @Test
    public void shouldBeAbleToGetPhoneNumber() {
        assertThat(account.getPhoneNumber(), is("0862389627"));
    }

    @Test
    public void shouldBeAbleToValidateAccountWithLibraryNumberAndPassword() {
        assertThat(account.validate("123-4567", "password"), is(true));
    }

    @Test
    public void shouldBeAbleToValidateAccountWithInvalidLibraryNumberAndPassword() {
        assertThat(account.validate("123-4567", "noIdea"), is(false));
    }


}