package ru.halievjanat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.halievjanat.builder.Hero;
import ru.halievjanat.builder.TypeHero;
import ru.halievjanat.decorator.AttackStrategyDecorator;
import ru.halievjanat.decorator.CriticalStrikeAttack;
import ru.halievjanat.strategy.AttackStrategy;
import ru.halievjanat.strategy.MeleeStrategy;
import ru.halievjanat.strategy.RangedStrategy;

public class TestDecorator {
    Hero heroOne, heroTwo;
    AttackStrategy attackStrategy;

    @BeforeEach
    public void setup() {
        heroOne = Hero.builder("Легалас", TypeHero.ARCHER)
                .attack(new RangedStrategy())
                .build();

        heroTwo = Hero.builder("Артур", TypeHero.WARRIOR)
                .build();

        attackStrategy = new MeleeStrategy();
    }

    @Test
    public void testDecorator() {
        AttackStrategyDecorator decorator = new CriticalStrikeAttack(attackStrategy);

        String criticalAttack = decorator.attack(heroOne, heroTwo);
        Assertions.assertEquals("Герой Легалас нанес ближний + критический удары по герою Артур", criticalAttack);
    }
}
