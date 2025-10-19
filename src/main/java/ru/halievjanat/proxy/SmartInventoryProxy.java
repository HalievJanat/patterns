package ru.halievjanat.proxy;

import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;

@Setter
@EqualsAndHashCode
public class SmartInventoryProxy implements Inventory {
    private final OrdinaryInventory ordinaryInventory;

    private boolean autoSort = true;

    public SmartInventoryProxy(int maxCapacity) {
        ordinaryInventory = new OrdinaryInventory(maxCapacity);
    }

    @Override
    public void addItem(Item item) {
        ordinaryInventory.addItem(item);
        if (autoSort) {
            sortedItems();
        }
    }

    private void sortedItems() {
        ordinaryInventory.getAll().sort(Comparator.comparing(Item::getName));
    }

    @Override
    public void removeItem(int itemId) {
        ordinaryInventory.removeItem(itemId);
    }

    @Override
    public Item getItem(int itemId) {
        return ordinaryInventory.getItem(itemId);
    }

    @Override
    public List<Item> getAll() {
        return ordinaryInventory.getAll();
    }

    @Override
    public boolean hasSpace() {
        return ordinaryInventory.hasSpace();
    }

    public String toString() {
        return this.ordinaryInventory.toString();
    }
}
