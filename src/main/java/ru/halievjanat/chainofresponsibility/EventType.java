package ru.halievjanat.chainofresponsibility;

import lombok.Getter;

@Getter
public enum EventType {
    FIRST_FILL("Первая кровь!"),
    LEVEL_UP("Новый уровень!"),
    KILL("Убийства!"),
    ITEM_COLLECTED("Сбор предметов!");

    private final String description;

    EventType(String description) {
        this.description = description;
    }
}
