package ru.halievjanat.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OldWeapon {
    private String name;
    private int damage;
    private int durability;

    public void use() {
        if (durability > 0) {
            durability--;
        }
    }
}
