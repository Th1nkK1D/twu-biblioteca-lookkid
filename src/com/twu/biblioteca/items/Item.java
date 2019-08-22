package com.twu.biblioteca.items;

public class Item {
    private String name;
    private String borrower;

    public Item(String name) {
        this.name = name;
        this.borrower = "";
    }

    public String getName() {
        return name;
    }

    public boolean getAvailability() {
        return this.borrower.length() == 0;
    }

    public String getBorrower() {
        return this.borrower;
    }

    public boolean checkoutItem(String borrower) {
        if(!this.getAvailability()) {
            return false;
        }

        this.borrower = borrower;
        return true;
    }

    public boolean returnItem() {
        if(this.getAvailability()) {
            return false;
        }

        this.borrower = "";
        return true;
    }
}
