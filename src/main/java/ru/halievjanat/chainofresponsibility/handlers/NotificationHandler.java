package ru.halievjanat.chainofresponsibility.handlers;

import ru.halievjanat.chainofresponsibility.GameEvent;

public class NotificationHandler extends GameEventHandler {
    @Override
    public boolean handle(GameEvent event) {

        System.out.printf("Событие: %s", event.getEventType().getDescription());

        return handleNext(event);
    }
}
