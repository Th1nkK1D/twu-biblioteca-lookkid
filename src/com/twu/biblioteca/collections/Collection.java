package com.twu.biblioteca.collections;

public interface Collection {
    boolean checkoutItem(String itemName, String borrower);
    boolean returnItem(String itemName);
    String getListOfAvailableItems();
    String getListOfAvailableItemsWithDetails();
}
