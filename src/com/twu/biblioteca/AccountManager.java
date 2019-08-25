package com.twu.biblioteca;

import java.util.TreeMap;

public class AccountManager {
    private TreeMap<String, Account> accounts;

    public AccountManager(TreeMap<String, Account> accounts) {
        this.accounts = accounts;
    }
    
    public boolean authenticate(String libraryNumber, String pass) {
        Account account = this.accounts.get(libraryNumber);

        if(account != null && account.validate(libraryNumber, pass)) {
            return true;
        }

        return false;
    }
}
