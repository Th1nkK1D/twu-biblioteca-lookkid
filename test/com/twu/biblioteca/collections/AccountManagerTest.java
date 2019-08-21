package com.twu.biblioteca.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AccountManagerTest {
    private AccountManager accountManager;

    @Before
    public void setUp() throws Exception {
        TreeMap<String, String> accounts = new TreeMap<>();
        accounts.put("user", "123-4567");

        this.accountManager = new AccountManager(accounts);
    }

    @Test
    public void authenticationShouldPassWithCorrectUserAndPassword() {
        assertThat(accountManager.authenticate("user", "123-4567"), is(true));
    }

    @Test
    public void authenticationShouldFailWithIncorrectPassword() {
        assertThat(accountManager.authenticate("user", "123-7776"), is(false));
    }

    @Test
    public void authenticationShouldFailWithIncorrectUser() {
        assertThat(accountManager.authenticate("aaa", "123-4567"), is(false));
    }
}