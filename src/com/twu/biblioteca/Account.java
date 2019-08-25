package com.twu.biblioteca;

public class Account {
    private String libraryNumber;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;

    public Account(String libraryNumber, String name, String password, String email, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean validate(String libraryNumber, String password) {
        return libraryNumber == this.libraryNumber && password == this.password;
    }
}
