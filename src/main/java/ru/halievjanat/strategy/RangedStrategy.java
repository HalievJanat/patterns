package ru.halievjanat.strategy;

import ru.halievjanat.builder.Hero;

public class RangedStrategy implements AttackStrategy {

    @Override
    public String attack(Hero attackerHero, Hero targetHero) {
        return "Герой " + attackerHero.getName() + " нанес дальний удар по герою " + targetHero.getName();
    }
}
