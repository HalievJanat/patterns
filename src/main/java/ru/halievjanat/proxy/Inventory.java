package ru.halievjanat.proxy;

import java.util.List;

public interface Inventory {
    void addItem(Item item);

    void removeItem(int itemId);

    Item getItem(int itemId);

    List<Item> getAll();

    boolean hasSpace();
}
