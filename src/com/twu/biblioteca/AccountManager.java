package com.twu.biblioteca;

import java.util.TreeMap;

public class AccountManager {
    private TreeMap<String, String> accounts;

    public AccountManager(TreeMap<String, String> accounts) {
        this.accounts = accounts;
    }
    
    public boolean authenticate(String user, String pass) {
        String savedPass = this.accounts.get(user);

        if(this.accounts.get(user) != null && pass == savedPass) {
            return true;
        }

        return false;
    }
}
