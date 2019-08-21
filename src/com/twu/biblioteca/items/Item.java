package com.twu.biblioteca.items;

public class Item {
    private String name;
    private boolean isAvailable;

    public Item(String name) {
        this.name = name;
        this.isAvailable = true;
    }

    public String getName() {
        return name;
    }

    public boolean getAvailability() {
        return isAvailable;
    }

    public boolean checkoutItem() {
        if(!this.isAvailable) {
            return false;
        }

        this.isAvailable = false;
        return true;
    }

    public boolean returnItem() {
        if(this.isAvailable) {
            return false;
        }

        this.isAvailable = true;
        return true;
    }
}
