package ru.halievjanat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.halievjanat.builder.Hero;
import ru.halievjanat.builder.TypeHero;
import ru.halievjanat.strategy.AttackStrategy;
import ru.halievjanat.strategy.MagicStrategy;
import ru.halievjanat.strategy.MeleeStrategy;
import ru.halievjanat.strategy.RangedStrategy;

import java.util.HashMap;
import java.util.Map;

public class TestStrategy {
    private static final Map<Integer, AttackStrategy> attacks = new HashMap<>();
    static Hero heroOne, heroTwo;

    @BeforeAll
    public static void setup() {
        attacks.put(1, new MagicStrategy());
        attacks.put(2, new MeleeStrategy());
        attacks.put(3, new RangedStrategy());

        heroOne = Hero.builder("Легалас", TypeHero.ARCHER)
                .build();

        heroTwo = Hero.builder("Артур", TypeHero.WARRIOR)
                .build();
    }

    @Test
    public void testMagicStrategy() {
        heroOne.setAttack(new MagicStrategy());

        Assertions.assertEquals("Герой Легалас нанес магический удар по герою Артур",
                attacks.get(1).attack(heroOne, heroTwo));
    }

    @Test
    public void testMeleeStrategy() {
        heroOne.setAttack(new MeleeStrategy());

        Assertions.assertEquals("Герой Легалас нанес ближний удар по герою Артур",
                attacks.get(2).attack(heroOne, heroTwo));
    }

    @Test
    public void testRangedStrategy() {
        heroOne.setAttack(new RangedStrategy());

        Assertions.assertEquals("Герой Легалас нанес дальний удар по герою Артур",
                attacks.get(3).attack(heroOne, heroTwo));
    }
}
