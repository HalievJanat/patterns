package ru.halievjanat.chainofresponsibility.handlers;

import ru.halievjanat.chainofresponsibility.GameEvent;

public abstract class GameEventHandler {
    protected GameEventHandler next;

    public GameEventHandler setNext(GameEventHandler next) {
        this.next = next;
        return next;
    }

    public abstract boolean handle(GameEvent event);

    protected boolean handleNext(GameEvent event) {
        if (next == null) return true;
        return next.handle(event);
    }
}
