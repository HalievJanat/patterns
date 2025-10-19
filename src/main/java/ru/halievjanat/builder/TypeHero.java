package ru.halievjanat.builder;

import lombok.Getter;

@Getter
public enum TypeHero {
    WARRIOR("Воин"), ARCHER("Лучник"), MAGE("Маг");

    private final String description;

    TypeHero(String description) {
        this.description = description;
    }
}
