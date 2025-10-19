package ru.halievjanat.chainofresponsibility.handlers;

import ru.halievjanat.chainofresponsibility.EventType;
import ru.halievjanat.chainofresponsibility.GameEvent;

public class AchievementHandler extends GameEventHandler {
    @Override
    public boolean handle(GameEvent event) {
        EventType eventType = event.getEventType();

        if (eventType == EventType.FIRST_FILL || eventType == EventType.LEVEL_UP) {
            System.out.printf("Достижение: %s", eventType.getDescription());
            return true;
        }

        return handleNext(event);
    }
}
