package com.twu.biblioteca.collections;

import com.twu.biblioteca.parser.ItemToStringParser;

public interface Collection {
    boolean checkoutItem(String itemName);
    boolean returnItem(String itemName);
    String printListOfAllItems(String header, ItemToStringParser parser);
}
