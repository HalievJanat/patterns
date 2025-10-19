package ru.halievjanat.strategy;

import ru.halievjanat.builder.Hero;

public class MagicStrategy implements AttackStrategy {

    @Override
    public String attack(Hero attackerHero, Hero targetHero) {
        return "Герой " + attackerHero.getName() + " нанес магический удар по герою " + targetHero.getName();
    }
}
