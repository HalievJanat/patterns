package ru.halievjanat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.halievjanat.builder.Hero;
import ru.halievjanat.builder.TypeHero;
import ru.halievjanat.chainofresponsibility.EventType;
import ru.halievjanat.chainofresponsibility.GameEvent;
import ru.halievjanat.chainofresponsibility.handlers.AchievementHandler;
import ru.halievjanat.chainofresponsibility.handlers.GameEventHandler;
import ru.halievjanat.chainofresponsibility.handlers.NotificationHandler;
import ru.halievjanat.chainofresponsibility.handlers.QuestHandler;
import ru.halievjanat.strategy.RangedStrategy;

public class TestChain {
    private GameEventHandler achievement;
    private Hero hero;

    @BeforeEach
    public void setup() {
        hero = Hero.builder("Легалас", TypeHero.ARCHER)
                .attack(new RangedStrategy())
                .build();

        achievement = new AchievementHandler();

        achievement.setNext(new QuestHandler()).setNext(new NotificationHandler());
    }

    @Test
    public void testChain() {
        GameEvent event = new GameEvent(EventType.ITEM_COLLECTED, hero);

        boolean result = achievement.handle(event);

        Assertions.assertTrue(result);
    }
}
