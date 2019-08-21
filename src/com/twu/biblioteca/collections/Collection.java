package com.twu.biblioteca.collections;

public interface Collection {
    boolean checkoutItem(String itemName);
    boolean returnItem(String itemName);
}
