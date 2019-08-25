package com.twu.biblioteca.collections;

import com.twu.biblioteca.Account;
import com.twu.biblioteca.AccountManager;
import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AccountManagerTest {
    private AccountManager accountManager;

    @Before
    public void setUp() throws Exception {
        TreeMap<String, Account> accounts = new TreeMap<>();
        accounts.put("123-4567", new Account("123-4567","John", "password", "test@mail.com", "0862389627"));

        this.accountManager = new AccountManager(accounts);
    }

    @Test
    public void authenticationShouldPassWithCorrectUserAndPassword() {
        assertThat(accountManager.authenticate("123-4567", "password"), is(true));
    }

    @Test
    public void authenticationShouldFailWithIncorrectPassword() {
        assertThat(accountManager.authenticate("123-4567", "pass"), is(false));
    }

    @Test
    public void authenticationShouldFailWithIncorrectUser() {
        assertThat(accountManager.authenticate("aaa", "password"), is(false));
    }
}