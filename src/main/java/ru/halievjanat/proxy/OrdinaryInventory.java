package ru.halievjanat.proxy;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
public class OrdinaryInventory implements Inventory {
    private final List<Item> items = new ArrayList<>();
    private final int maxCapacity;

    public OrdinaryInventory(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public void addItem(Item item) {
        if (items.size() >= maxCapacity) {
            throw new IllegalArgumentException("Инвентарь полон!");
        }
        items.add(item);
    }

    @Override
    public void removeItem(int itemId) {
        items.removeIf(item -> item.getId() == itemId);
    }

    @Override
    public Item getItem(int itemId) {
        return items.stream()
                .filter(item -> item.getId() == itemId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Item> getAll() {
        return items;
    }

    @Override
    public boolean hasSpace() {
        return items.size() < maxCapacity;
    }

    public String toString() {
        return "Inventory(items=" + this.items + ", maxCapacity=" + this.maxCapacity + ")";
    }
}
