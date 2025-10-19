package ru.halievjanat.chainofresponsibility.handlers;

import ru.halievjanat.chainofresponsibility.EventType;
import ru.halievjanat.chainofresponsibility.GameEvent;

public class QuestHandler extends GameEventHandler {
    @Override
    public boolean handle(GameEvent event) {
        EventType eventType = event.getEventType();

        if (eventType == EventType.KILL || eventType == EventType.ITEM_COLLECTED) {
            System.out.printf("Обновление прогресса квеста: %s", eventType.getDescription());
            return true;
        }

        return handleNext(event);
    }
}
